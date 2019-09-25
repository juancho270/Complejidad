% Use this editor as a MiniZinc scratch book
int: numero; %numero de noticias
int: Limite; %limite de paginas total para el peridico
array[1..numero] of int: LimInf; %lista de limites inferiores
array[1..numero] of int: LimSup; %lista de limites superiores
array[1..numero] of int: PotLec; %lista de lectores potenciales
array[1..numero] of string: NomTop; %lista con el nombre de las noticias
%Variables 
array[1..numero] of var int: x; %Variable que representa el numero de paginas por noticia
%Restricciones:
constraint sum(j in 1..numero)(x[j]) = Limite; %restriccion que no supere el limite de paginas
constraint forall(j in 1..numero)(x[j] <= LimSup[j]) ; %restriccion que no se supere el limite superior
constraint forall(j in 1..numero)(x[j] >= LimInf[j] \/ x[j] = 0); %restriccion que no supere el limite inferior
%Objetivo
var int: utilidad;
constraint utilidad = sum(j in 1..numero)(PotLec[j] * x[j]); %funcion objetivo
solve maximize utilidad;
output ["Numero de paginas por topic: \n"] ++ [ "\(NomTop[j]);\(x[j]);\(PotLec[j]);\((PotLec[j]) * (x[j]))\n" | j in 1..numero]; %salida

