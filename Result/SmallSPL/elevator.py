"""
Created on Thu Dec 23 19:50:47 2018
pairwise similarity matrix for jaccard and hamming metric
Name of Software Product Line: Elevator
Number Of Features : 6
@author: Zahra Khoshmanesh
"""

"""
pair of feature interaction in Elevator SPL
    
Overloaded-Empty
2/3 full- Empty
Executivefloor-Empty
2/3full-Overloaded
Executivefloor-Overloaded
Executivefloor-2/3full
 """


# Program to perform different set operations 
# as we do in  mathematics 
  
#function for calculating Jaccard similarity 
def Jaccard(Feature1,Feature2):    
    # union 
    union_f=Feature1|Feature2     
    # intersection 
    intersection_f=Feature1&Feature2    
    #jaccard
    jaccard_score=len(intersection_f)/len(union_f)
    return jaccard_score

#function for calculating Hamming similarity 
    
def Hamming(Feature1,Feature2,Setall):    
    # intersection 
    intersection_f=Feature1&Feature2
     #difference 1
    difference1=Setall-Feature1
    #difference 2
    difference2=Setall-Feature2 
    #intersection of difference
    diff_intersection=difference1&difference2
    #jaccard
    hamming_score=(len(intersection_f)+len(diff_intersection))/len(Setall)
    return hamming_score
# define feature sets for mine pump software product line
    
#base feature
	        
base_f = {"weight","leaveElevator" ,"origin","isDestinationReached","destination","enterElevator","name","pressInLiftFloorButton","destinationReached","processWaitingPersons", 
        		"env","addWaitingPerson","thisFloorID","callElevator","elevatorCall","reset","waiting","hasCall","additionalButtons","isBlocked","floors","enterElevator","numFloors",
                "leaveElevator","isTopFloor","pressInLiftFloorButton","resetFloorButton","currentFloorID","areDoorsOpen","Direction","timeShift","currentHeading",
                "stopRequestedAtCurrentFloor" ,"persons","stopRequestedInDirection","DoorState","continueInDirection","floorButtons","isAnyLiftButtonPressed", 
        		"doors","hasCall","dir","anyStopRequested","buttonForFloorIsPressed","isEmpty","isIdle"}
     
empty = {"Person","floorButtons","numFloors","floors","id","leaveElevator","isEmpty","isTopFloor","original"}
                
executivefloor = {"executiveFloor","floorID","currentFloorID","dir","respectFloorCalls","respectInLiftCalls","Floor","floors","isExecutiveFloor","isExecutiveFloorCalling",
                  "stopRequestedAtCurrentFloor","stopRequestedInDirection","hasCall","original"}
          
overloaded = {"blocked","weight","maximumWeight","timeShift","areDoorsOpen","isBlocked","original"}  
	             
twothirdsfull = {"weight","maximumWeight","floorButtons","currentFloorID","dir","respectFloorCalls","respectInLiftCalls","stopRequestedAtCurrentFloor",
                 "original","stopRequestedInDirection",	"isAnyLiftButtonPressed"}       
	             
weight = {"weight","maximumWeight","Person","leaveElevator","enterElevator","original"} 
	             
# end of feature define

#set of all feature set  
	            
all_feature_set=[base_f,empty,executivefloor,overloaded,twothirdsfull,weight]
print("number of features in the SPL",len(all_feature_set))

#creating super set of all features for hamming
for i in range(0, len(all_feature_set)):
    #union_all.union(all_feature_set[i])
    union_all=union_all | all_feature_set[i]
    #print(all_feature_set[i])
    #print('\n')
    
print("length of S(set of all)",len(union_all))
print("length of base",len(base_f))


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
    
"""
pair of feature interaction in Elevator SPL
    
Overloaded-Empty
2/3 full- Empty
Executivefloor-Empty
2/3full-Overloaded
Executivefloor-Overloaded
Executivefloor-2/3full
 """
 # list of feature interaction in Elevator SPL
FI_Pairs=[[overloaded,empty],[twothirdsfull,empty],[executivefloor,empty],[twothirdsfull,overloaded],
          [executivefloor,overloaded],[executivefloor,twothirdsfull]]

Features=[empty,executivefloor,overloaded,twothirdsfull,weight]

numrows = len(FI_Pairs)   
numcols = len(FI_Pairs[0]) 

distance = [[[0 for k in range(len(Features))] for j in range(numcols)] for i in range(numrows)]
for i in range (numrows):    
    for j in range (numcols):
        F1=FI_Pairs[i][j]        
        for k in range (len(Features)):
             print("%.2f" % Jaccard(F1,Features[k]),end=" ")
             distance[i][j][k]=Jaccard(F1,Features[k])             
        print('\n')
        sortd[i][j].sort(reverse=True)
    print('\n')

             
