import bme280
import smbus2
import time
import serial
import pynmea2
from time import sleep

port = 1
address = 0x77 #Adafruit BME280 address. Other BME280s may be different
bus = smbus2.SMBus(port)

#$GNVTG VTG-Vector Track and Speed over Ground
#$GNGGA GGA-essential fix data which provides 3D location and accuracy data
#$GNGLL GLL-Geographic Lat and Long
#$GNGSA GSA-detial on "Fix" includes number of Satellites
#$GNRMC RMC-The recommended Minimum

bme280.load_calibration_params(bus,address)
bme280_data = bme280.sample(bus,address)

file = open("output.txt", "a")

def parseGPS(str):
	if str.find('GGA') > 0:
		msg = pynmea2.parse(str)
		print ("GPS Timestamp: %s -- Lat: %s %s -- Lon: %s %s -- Altitude: %s %s --Satellites: %s" %(msg.timestamp, msg.lat, msg.lat_dir, msg.lon, msg.lon_dir, msg.altitude, msg.altitude_units, msg.num_sats))
		file = open("output.txt", "a")
		file.write("GPS Timestamp: %s -- Lat: %s %s -- Lon: %s %s -- Altitude: %s %s --Satellites: %s\n" %(msg.timestamp, msg.lat, msg.lat_dir, msg.lon, msg.lon_dir, msg.altitude, msg.altitude_units, msg.num_sats))
		sleep(60)
		
def grabDME():
    #ident = bme280_data.id
    file = open("output.txt", "a")
    print("DME Timestamp: %s -- Humidity: %s -- Pressure: %s -- Temperature: %s"%(bme280_data.timestamp, bme280_data.humidity, bme280_data.pressure, bme280_data.temperature))
    file.write("DME Timestamp: %s -- Humidity: %s -- Pressure: %s -- Temperature: %s \n"%(bme280_data.timestamp, bme280_data.humidity, bme280_data.pressure, bme280_data.temperature))
	
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
        grabDME()
        raise AttributeError("Fault in Receieved GPS")
    except AttributeError as e:
        ser.close()
        ser.open()
        str = ser.readline()
        parseGPS(str)
        grabDME()
    else:
        str = ser.readline()
        parseGPS(str)
        grabDME()
