# FIDUS:  Feature  Interaction  Detection  Using  Similarity  in  Software  ProductLines

## Leveraging Feature Similarity for EarlierDetection of Unwanted Feature Interactions inEvolving Software Product Lines

Seyedehzahra Khoshmanesh and Robyn R. Lutz

Iowa State University, Ames IA 50011, USA

{zkh,rlutz}@iastate.edu


## Abstract

Software product lines enable reuse of shared software acrossa  family  of  products.  As  new  products  are  built  in  the  product  line,new  features  are  added.  The  features  are  units  of  functionality  thatprovide  services  to  users.  Unwanted  feature  interactions,  wherein  onefeature interferes with another feature’s operation, is a significant prob-lem, especially as large software product lines evolve. Detecting featureinteractions is a time-consuming and difficult task for developers. More-over,  feature  interactions  are  often  only  discovered  during  testing,  atwhich point costly re-work is needed. We seek to discover feature inter-actions much earlier in the development process. This paper proposes asimilarity-based method to achieve earlier detection of unwanted featureinteractions. It uses knowledge of prior feature interactions stored in thesoftware product line’s feature model to help find unwanted interactionsbetween  a  new  feature  and  existing  features.  The  paper  describes  theframework and algorithms used to detect the feature interactions usingthree  path  similarity  measures  and  evaluates  the  approach  on  a  real-world, evolving software product line. Results show that the approachperforms  well,  with  83%  accuracy  and  60%  to  100%  coverage  of  fea-ture interactions in experiments, and that the approach scales to a largenumber of features.
