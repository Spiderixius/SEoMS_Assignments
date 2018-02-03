import csv
import folium
import numpy as np


# Data types
walkingPoints = []
runningPoints = []
bikingPoints = []
drivingPoints = []



path = "/home/spider/Documents/mobileSystems/Assignment3/mobileCSVData/"

# Reading from the .csv file
with open(path+"Running.csv") as csvfile:
    rdr = csv.reader( csvfile )
    for i, row in enumerate( rdr ):
        if i == 0: continue # Skip column titles
        lat, lon= row[3:5]
        runningPoints.append(tuple([float(lat), float(lon)]))

with open(path+"Driving.csv") as csvfile:
    rdr = csv.reader( csvfile )
    for i, row in enumerate( rdr ):
        if i == 0: continue # Skip column titles
        lat, lon= row[3:5]
        drivingPoints.append(tuple([float(lat), float(lon)]))

with open(path+"Biking.csv") as csvfile:
    rdr = csv.reader( csvfile )
    for i, row in enumerate( rdr ):
        if i == 0: continue # Skip column titles
        lat, lon= row[3:5]
        bikingPoints.append(tuple([float(lat), float(lon)]))

with open(path+"Walking.csv") as csvfile:
    rdr = csv.reader( csvfile )
    for i, row in enumerate( rdr ):
        if i == 0: continue # Skip column titles
        lat, lon= row[3:5]
        walkingPoints.append(tuple([float(lat), float(lon)]))

print (len(walkingPoints))
print (walkingPoints)

# Median and mean
medianPoints= []
meanPoints= []
for idx, val in enumerate(walkingPoints):
    range = walkingPoints[idx:idx + 10]
    latAr = [];
    lonAr= [];
    for i,j in range:
        latAr.append(i)
        lonAr.append(j)
    print(latAr)
    latMean = np.mean(latAr);
    lonMean = np.mean(lonAr);
    latMedian = np.median(latAr)
    lonMedian = np.median(lonAr)
    print (latMedian)
    medianPoints.append(tuple([float(latMedian), float(lonMedian)]))
    meanPoints.append(tuple([float(latMean), float(lonMean)]))
print (len(medianPoints))

print(walkingPoints)
print(medianPoints)

avg_lat = sum(p[0] for p in walkingPoints) / len(walkingPoints)
avg_lon = sum(p[1] for p in walkingPoints) / len(walkingPoints)

# Load map centred on average coordinates
fmap = folium.Map(location=[avg_lat, avg_lon], zoom_start=14)

# Drawing of lines
folium.PolyLine(walkingPoints, color="red", weight=2.5, opacity=1).add_to(fmap)
# folium.PolyLine(medianPoints, color="blue", weight=2.5, opacity=1).add_to(fmap)
# folium.PolyLine(pointsMean, color="blue", weight=2.5, opacity=1).add_to(fmap)

# The other data types
folium.PolyLine(runningPoints, color="yellow", weight=2.5, opacity=1).add_to(fmap)
folium.PolyLine(bikingPoints, color="black", weight=2.5, opacity=1).add_to(fmap)
folium.PolyLine(drivingPoints, color="purple", weight=2.5, opacity=1).add_to(fmap)

# Save map
fmap.save(path+"allRawDataPlotted.html")
