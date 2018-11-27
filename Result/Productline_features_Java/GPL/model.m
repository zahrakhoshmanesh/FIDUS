/* GPL domain model July 2005 */

// grammar 

GPL : Driver Alg+ [Src] [Wgt] Gtp Base:: MainGpl ;

Gtp : Directed | Undirected ;

Wgt : Weighted | Unweighted ;

Src: Src2 Search :: SrcProg;

Src2 : BFS | DFS ;

Alg : Number | Connected | Transpose StronglyConnected :: StrongC 
    | Cycle | MSTPrim | MSTKruskal | Shortest ;

Driver : Prog Benchmark :: DriverProg ;

%% // constraints

Number implies Gtp and Src ;
Connected implies Undirected and Src;
StrongC implies Directed and DFS ;
Cycle implies Gtp and DFS;
MSTKruskal or MSTPrim implies Undirected and Weighted ;
MSTKruskal or MSTPrim implies not (MSTKruskal and MSTPrim) ;
Shortest implies Directed and Weighted ;

