import pandas as pd
import numpy as np



data = {
     'Ticker Name': ['Xavier', 'Ann', 'Jana', 'Yi', 'Robin', 'Amal', 'Nori'],
     'city': ['Mexico City', 'Toronto', 'Prague', 'Shanghai',
              'Manchester', 'Cairo', 'Osaka'],
     'Last Price': [41, 28, 33, 34, 38, 31, 37],
     'py-score': [88.0, 79.0, 81.0, 80.0, 68.0, 61.0, 84.0]
 }

df = pd.DataFrame( data = data)
print(df)
print("==========================================================")
##print(df[['name','age']])

##print(df.loc[2])
##print(df.loc[2])

##print(df.loc[:,'name'])
##print(df.iloc[:,2])




##for i in range(len(df)):
##    print(df.loc[i, "name"], df.loc[i, "age"])
####print(df.iloc[:,2])


dataColDetails = {
        'blp_Name':['Ticker Name','Last Price'],
        'Export_Name':['Ticker','LastPrice']
    }

dfColDetails  = pd.DataFrame(data=dataColDetails)

print(dfColDetails)

blpCols =  dfColDetails['blp_Name'].to_numpy()
exportCols =  dfColDetails['Export_Name'].to_numpy()

print(blpCols,exportCols)

dfResult = pd.DataFrame(columns =exportCols)


for i in range(len(df)):
    vals =[]
    for j in range(len(dfColDetails)):
##        print(dfColDetails.loc[j,"blp_Name"])
        vals.append(df.loc[i,dfColDetails.loc[j,"blp_Name"]])

    dfResult.loc[i]=vals

print(dfResult)    
        
    
    


####print("Ab Test")
##
##d = {'x': [1, 2, 3], 'y': np.array([2, 4, 8]), 'z': 100}
##
##df_1 = pd.DataFrame(d)
##
##print(df_1)
