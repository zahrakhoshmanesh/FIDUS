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

#function for calculating Hamming similarity 
    
def Hamming(Feature1,Feature2,Setall):    
    # intersection 
    intersection_f=Feature1 & Feature2
    #difference 1
    difference1=Setall-Feature1
    #difference 2
    difference2=Setall-Feature2  
    #intersection of difference
    diff_intersection=difference1 & difference2
    #jaccard
    hamming_score=(len(intersection_f)+len(diff_intersection))/len(Setall)
    return hamming_score
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

#creating super set of all features for hamming
union_all=all_feature_set[1]
for i in range(2, len(all_feature_set)):
    union_all.union(all_feature_set[i])

#producing pairwise similarity matrix for jaccard
print("Matrix of pairwise similarity- Jaccard")
print('\n')
for i in range(0, len(all_feature_set)):
    for j in range(0, len(all_feature_set)):
        print("%.2f" % Jaccard(all_feature_set[i],all_feature_set[j]),end=",") 
    print('\n')
    
#producing pairwise similarity matrix for hamming
print("Matrix of pairwise similarity- Hamming")
print('\n')
for i in range(0, len(all_feature_set)):
    for j in range(0, len(all_feature_set)):
        print("%.2f" % Hamming(all_feature_set[i],all_feature_set[j],union_all),end=",") 
    print('\n')
    

    

 
    