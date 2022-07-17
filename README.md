# Api MeLi

API Rest desarrollada con Java 11 y Spring Boot, siguiendo las consignas
[**en este link**](https://github.com/RodriiCruz/api-rest-meli/blob/main/Examen%20Mercadolibre%20%20-%20Mutantes.pdf)

Ejecutar el siguiente comando para correr el servidor:

```
java -jar api-meli.jar
```

**Ejemplos de body para POST/mutant**


*{
"dna":["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]
}*

*{
"dna":["TTGCGA","CAGTGC","TTATGT","AGAAGG","CGCCTA","TCACTG"]
}*

*{
"dna":["TTGCTA","CAGTGC","TTATGT","AAAAGG","CCCCTA","TCACTG"]
}*
