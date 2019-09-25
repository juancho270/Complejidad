% Use this editor as a MiniZinc scratch book
int: numero;
int: Limite;
array[1..numero] of int: LimInf;
array[1..numero] of int: LimSup;
array[1..numero] of int: PotLec;
array[1..numero] of string: NomTop;
%Variables 
array[1..numero] of var int: x;
%Restricciones:
constraint sum(j in 1..numero)(x[j]) = Limite;
constraint forall(j in 1..numero)(x[j] <= LimSup[j]) ;
constraint forall(j in 1..numero)(x[j] >= LimInf[j] \/ x[j] = 0);
%Objetivo
var int: utilidad;
constraint utilidad = sum(j in 1..numero)(PotLec[j] * x[j]);
solve maximize utilidad;
output ["Numero de paginas por topic: \n"] ++ [ "\(NomTop[j]);\(x[j]);\(PotLec[j]);\((PotLec[j]) * (x[j]))\n" | j in 1..numero];

