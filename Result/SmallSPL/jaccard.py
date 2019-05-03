"""
Created on Thu Dec 13 12:37:47 2018
pairwise similarity matrix for jaccard metric
Name of Software Product Line: Mine Pump
Number Of Features : 7
@author: Zahra Khoshmanesh
"""

# Program to perform different set operations 
# as we do in  mathematics 
  
#function for calculating Jaccard similarity 
def Jaccard(Feature1,Feature2):
    
    # union 
    union_f=Feature1 | Feature2
     
    # intersection 
    intersection_f=Feature1 & Feature2
    
    #jaccard
    jaccard_score=len(intersection_f)/len(union_f)
    return jaccard_score
    

# define feature sets for mine pump software product line
    
#base feature
	        
base_f = {"pumpRunning","systemActive","waterLevel","methaneLevelCritical","timeShift","processEnvironment","activatePump","deactivatePump","isMethaneAlarm","lowerWaterLevel","waterRise","changeMethaneLevel","isMethaneLevelCritical"}  
	        
 #highWaterSensor feature	
       
highWaterSensorvalue = {"waterLevel","pumpRunning","isHighWaterSensorDry","processEnvironment","isHighWaterLevel","activatePump"}
 	        
#lowWaterSensor feature
	              
lowWaterSensorvalue = {"waterLevel","pumpRunning","isLowWaterSensorDry","processEnvironment","isLowWaterLevel","deactivatePump"}
	        
	                    
 #methaneAlarm feature
	          
methaneAlarmvalue = {"pumpRunning","processEnvironment","isMethaneAlarm","deactivatePump"}  
	        
#methaneQuery feature
	             
methaneQueryvalue = {"activatePump","isMethaneAlarm"} 
            
	        
	        
#startCommand feature
	             
startCommandvalue = {"systemActive","startSystem"} 
	             
	            
#stopCommand feature
	               
stopCommandvalue = {"pumpRunning","systemActive","stopSystem","deactivatePump"}

# end of feature define

#set of all feature set  
	            
all_feature_set=[{"pumpRunning","systemActive","waterLevel","methaneLevelCritical","timeShift","processEnvironment","activatePump","deactivatePump","isMethaneAlarm","lowerWaterLevel","waterRise","changeMethaneLevel","isMethaneLevelCritical"},{"waterLevel","pumpRunning","isHighWaterSensorDry","processEnvironment","isHighWaterLevel","activatePump"},{"waterLevel","pumpRunning","isLowWaterSensorDry","processEnvironment","isLowWaterLevel","deactivatePump"},{"pumpRunning","processEnvironment","isMethaneAlarm","deactivatePump"} ,{"activatePump","isMethaneAlarm"},{"systemActive","startSystem"} ,{"pumpRunning","systemActive","stopSystem","deactivatePump"}]

#number of features in Software product line
#print(len(all_feature_set))

#producing pairwise similarity matrix
print("Matrix of pairwise similarity- Jaccard")
print('\n')
for i in range(0, len(all_feature_set)):
    for j in range(0, len(all_feature_set)):
        print("%.2f" % Jaccard(all_feature_set[i],all_feature_set[j]),end=",") 
    print('\n')



 
    