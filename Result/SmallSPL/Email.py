"""
Created on Thu Dec 23 19:50:47 2018
pairwise similarity matrix for jaccard and hamming metric
Name of Software Product Line: E-mail
Number Of Features : 9
@author: Zahra Khoshmanesh
"""

"""
pair of feature interaction in E-Mail SPL

Decrypt, Forward (0)
Addressbook, Encrypt (1)
Sign, Verify (3)
Sign, Forward (4)
Encrypt, Decrypt (6)
Encrypt, Verify (7)
Encrypt, Autoresponder (8)
Encrypt, Forward (9)
Decrypt, Autoresponder (11)
Autoresponder- Forward (13)
Verify- Forward (27)


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
	        
base_f = {"id","name","clientcounter","clients","subject","body","from","to","emailcounter",
          "deliver","incoming","mail","outgoing","sendemail","client","getname","createclient","getclientbyid","getclientbyaddress",
          "resetclients","tostring","email","createemail","isreadable","printmail","cloneemail","getemailfrom","getid","getemailsubject",
          "getemailto","setemailbody","setemailfrom","setemailsubject","setemailto","getemailbody"}
     
addressbook = {"addressbook","alias","receivers","getaddressbookreceiversforalias","addaddressbookentry",
               "outgoing","addressbookentry","addreceiver","getalias","getreceivers"}
                
autoresponder = {"autoresponse","setautoresponse","isautoresponse","autorespond","incoming"}
          
decrypt = {"privkey","incoming"}  
	             
encrypt = {"isencrypted","encryptionkey","pubkey","isreadable","printmail","isencrypted","setemailencryptionkey","getemailencryptionkey","outgoing"}      
	             
forward = {"forwardreceiver","setforwardreceiver","getforwardreceiver","forward","incoming"} 

keys={"ketring","privkey","keyowner","pubkey","setprivatekey","getprivatekey","generatekeypair","addkeyringentry",
      "getkeyringpublickeybyclient","iskeypairvalid","keyringentry","getkeyowner","getpublickey"}

sign={"privkey","signed","signkey","outgoing","sign","printmail","setemailissigned","setemailsignkey","issigned","getemailsignkey"}
verify={"pubkey","issignatureverified","incoming","verify","printmail","issignatureverified","setissignatureverified"}
	             
# end of feature define

#set of all feature set  
#print (len (base_f | (addressbook |(autoresponder | (decrypt | (encrypt |(forward |(keys | (sign | verify))))))))	)            
all_feature_set=[base_f,addressbook,autoresponder,decrypt,encrypt,forward,keys,sign,verify]
print("number of features in the SPL",len(all_feature_set))
#union_all=(base_f | (addressbook |(autoresponder | (decrypt | (encrypt |(forward |(keys | (sign | verify))))))))

#creating super set of all features for hamming
union_all=all_feature_set[0]
for i in range(0, len(all_feature_set)):
    #union_all.union(all_feature_set[i])
    union_all=union_all | all_feature_set[i]
    #print(len(all_feature_set[i]))
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
pair of feature interaction in E-Mail SPL

Decrypt, Forward (0)
Addressbook, Encrypt (1)
Sign, Verify (3)
Sign, Forward (4)
Encrypt, Decrypt (6)
Encrypt, Verify (7)
Encrypt, Autoresponder (8)
Encrypt, Forward (9)
Decrypt, Autoresponder (11)
Autoresponder- Forward (13)
Verify- Forward (27)


"""
# list of feature interaction in Email SPL
FI_Pairs=[{decrypt,forward},{addressbook,encrypt},{sign,verify},{sign,forward},{encrypt,decrypt},
          {encrypt,verify},{encrypt,autoresponder},{encrypt,forward},{decrypt,autoresponder},{autoresponder,forward},{verify,forward}]


