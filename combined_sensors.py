import bme280
import smbus2
import time
import serial
import pynmea2
import math
import io
from time import sleep
import pymysql

try:
    mydb = pymysql.connect(
        host = "db4free.net",
        user = "clc361_group",
        password = "Group_CLC361",
        database = "clc361_group"
        )
    print(mydb)
except AttributeError as e:
    print(e)
    
mycursor = mydb.cursor()

# sqldme = "INSERT INTO Sensors (DTStamp, Temperature, Humidity, Pressure, Altitude) VALUES (%s, %s, %s, %s, %s)"
# sqlgps = "INSERT INTO Sensors (GPSTimeStamp, GPSLat, GPSLong, GPSAltitude, GPSNumSat) VALUES(%s, %s, %s, %s, %s)"
sql = "INSERT INTO Sensors (DTStamp, Temperature, Humidity, Pressure, Altitude, GPSTimeStamp, GPSLat, GPSLong, GPSAltitude, GPSNumSat) VALUES (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s)"

ser = serial.Serial(
	port='/dev/ttyS0',
	baudrate = 9600,
	#parity = serial.PARITY_NONE,
	#stopbits = serial.STOPBITS_ONE,
	bytesize = serial.EIGHTBITS,
	timeout=6,
    write_timeout=0
)
sio = io.TextIOWrapper(io.BufferedRWPair(ser,ser))

port = 1
address = 0x77 #Adafruit BME280 address. Other BME280s may be different
bus = smbus2.SMBus(port)

times = time.localtime(time.time())
print (times)

#$GNVTG VTG-Vector Track and Speed over Ground
#$GNGGA GGA-essential fix data which provides 3D location and accuracy data
#$GNGLL GLL-Geographic Lat and Long
#$GNGSA GSA-detial on "Fix" includes number of Satellites
#$GNRMC RMC-The recommended Minimum

bme280.load_calibration_params(bus,address)
bme280_data = bme280.sample(bus,address)

GPS_hit = False

file = open("output.txt", "a")

def parseGPS(strg):
	if 'GNGGA' in strg:
		msg = pynmea2.parse(strg)
		print ("GPS Timestamp: %s -- Lat: %s %s -- Lon: %s %s -- Altitude: %s %s --Satellites: %s" %(msg.timestamp, msg.lat, msg.lat_dir, msg.lon, msg.lon_dir, msg.altitude, msg.altitude_units, msg.num_sats))
# 		file = open("output.txt", "a")
# 		file.write("GPS Timestamp: %s -- Lat: %s %s -- Lon: %s %s -- Altitude: %s %s --Satellites: %s\n" %(msg.timestamp, msg.lat, msg.lat_dir, msg.lon, msg.lon_dir, msg.altitude, msg.altitude_units, msg.num_sats))
# 		val = (str(msg.timestamp), str(msg.lat), str(msg.lon), str(msg.altitude), str(msg.num_sats))
# 		mycursor.execute(sqlgps, val)
# 		mydb.commit()
		bme280_data = bme280.sample(bus,address)
		times = bme280_data.timestamp
		hum = bme280_data.humidity
		press = bme280_data.pressure
		temp = bme280_data.temperature
		alt = convertPressAlt(press)
		file = open("output.txt", "a")
		print("DME Timestamp: %s -- Humidity: %s -- Pressure: %s -- Temperature: %s -- Altitude: %f"%(times, hum, press, temp, alt))
# 		file.write("DME Timestamp: %s -- Humidity: %s -- Pressure: %s -- Temperature: %s -- Altitude: %f \n"%(times, hum, press, temp, alt))
		val1 = (times, temp, hum, press, alt, str(msg.timestamp), str(msg.lat), str(msg.lon), str(msg.altitude), str(msg.num_sats))
		mycursor.execute(sql, val1)
		mydb.commit()
		sleep(300)
	
		
# 		grabDME is depricated
# def grabDME():
#     #ident = bme280_data.id
#     bme280_data = bme280.sample(bus,address)
#     times = bme280_data.timestamp
#     hum = bme280_data.humidity
#     press = bme280_data.pressure
#     temp = bme280_data.temperature
#     alt = convertPressAlt(press)
#     file = open("output.txt", "a")
#     print("DME Timestamp: %s -- Humidity: %s -- Pressure: %s -- Temperature: %s -- Altitude: %f"%(times, hum, press, temp, alt))
#     file.write("DME Timestamp: %s -- Humidity: %s -- Pressure: %s -- Temperature: %s -- Altitude: %f \n"%(times, hum, press, temp, alt))
#     val1 = (times, temp, hum, press, alt)
#     mycursor.execute(sqldme, val1)
#     mydb.commit()
#    sleep(60)

def convertPressAlt(press):
    # PA = 145366.45 (feet) or 44331(meters) x [1 - (Pa / 1013.25 (for millibar or 29.92 in/Hg) ^ 0.190284] where PA = Pressure Altitude in feet and Pa = Field Pressure, 1013.25 = millibar pressure at STA
    x = press / 1013.25
    y = math.pow(x, 0.190284)
    z = 1 - y
    PA = 44331 * z
#    print (PA)
    return PA

while 1:
    try:
        strg = sio.readline()       
        parseGPS(strg)
        raise AttributeError("Fault in Receieved GPS")
    except AttributeError as e:
        strg = sio.readline()
        parseGPS(strg)
    else:
        strg = sio.readline()
        parseGPS(strg)
        ser.close()
