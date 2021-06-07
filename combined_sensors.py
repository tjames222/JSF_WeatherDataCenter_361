import bme280
import smbus2
import time
import serial
import pynmea2
from time import sleep
# import mysql.connector as mysql
# 
# mydb = mysql.connect(
#     host= "sql112.epizy.com",
#     user= "epiz_28807546",
#     password= "YVLxc64OIbFf",
#     database= "epiz_28807546_361_IoT"
# )
# 
# print(mydb)
# 
# mycursor = mydb.cursor()
# 
# sqldme = "INSERT INTO Sensor (DTStamp, Temperature, Humidity, Pressure) VALUES (%s, %s, %s, %s)"
# sqlgps = "INSERT INTO Sensor (GPSTimeStamp, GPSLat, GPSLong, GPSAltitude, GPSSatNum) VALUES(%s, %s, %s, %s, %s)"


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

def parseGPS(str):
	if str.find('GGA') > 0:
		msg = pynmea2.parse(str)
		print ("GPS Timestamp: %s -- Lat: %s %s -- Lon: %s %s -- Altitude: %s %s --Satellites: %s" %(msg.timestamp, msg.lat, msg.lat_dir, msg.lon, msg.lon_dir, msg.altitude, msg.altitude_units, msg.num_sats))
		file = open("output.txt", "a")
		file.write("GPS Timestamp: %s -- Lat: %s %s -- Lon: %s %s -- Altitude: %s %s --Satellites: %s\n" %(msg.timestamp, msg.lat, msg.lat_dir, msg.lon, msg.lon_dir, msg.altitude, msg.altitude_units, msg.num_sats))
# 		val = (msg.timestamp, msg.lat, msg.lat_dir, msg.lon, msg.lon_dir, msg.altitude, msg.altitude_units, msg.num_sats)
# #		ser.close()
# 		mycursor.execute(sqlgps, val)
# 		mydb.commit()
		grabDME()
		sleep(300)
		
		
def grabDME():
    #ident = bme280_data.id
    bme280_data = bme280.sample(bus,address)
    times = bme280_data.timestamp
    hum = bme280_data.humidity
    press = bme280_data.pressure
    temp = bme280_data.temperature
    file = open("output.txt", "a")
    print("DME Timestamp: %s -- Humidity: %s -- Pressure: %s -- Temperature: %s"%(times, hum, press, temp))
    file.write("DME Timestamp: %s -- Humidity: %s -- Pressure: %s -- Temperature: %s \n"%(times, hum, press, temp))
#     val1 = (times, temp, hum, press)
#     mycursor.execute(sqldme, val1)
#     mydb.commit()
#    sleep(60)

ser = serial.Serial(
	port='/dev/ttyS0',
	baudrate = 9600,
	#parity = serial.PARITY_NONE,
	#stopbits = serial.STOPBITS_ONE,
	bytesize = serial.EIGHTBITS,
	timeout=600,
    write_timeout=0
)

while 1:
    try:
        str = ser.readline()
        parseGPS(str)
#         grabDME()
#        ser.close()
        raise AttributeError("Fault in Receieved GPS")
    except AttributeError as e:
#        ser.open()
        str = ser.readline()
        parseGPS(str)
#         grabDME()
    else:
        str = ser.readline()
        parseGPS(str)
#         grabDME()
        ser.close()
