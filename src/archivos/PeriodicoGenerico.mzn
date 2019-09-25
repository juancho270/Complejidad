% Use this editor as a MiniZinc scratch book
int: n;
int: L;
array[1..n] of int: LI;
array[1..n] of int: LS;
array[1..n] of int: PL;
array[1..n] of string: NT;
%Variables 
array[1..n] of var int: x;
%Restricciones:
constraint sum(j in 1..n)(x[j]) = L;
constraint forall(j in 1..n)(x[j] <= LS[j]) ;
constraint forall(j in 1..n)(x[j] >= LI[j] \/ x[j] = 0);
%Objetivo
var int: utilidad;
constraint utilidad = sum(j in 1..n)(PL[j] * x[j]);
solve maximize utilidad;
output ["Numero de paginas por topic: \n"] ++ [ "\(NT[j]);\(x[j]);\(PL[j]);\((PL[j]) * (x[j]))\n" | j in 1..n];

