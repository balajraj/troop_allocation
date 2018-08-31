# Introduction troop allocation library
* A simple java libraray is written to do the troop allocation. The library will take the following inputs, the total  size of the army, some weights and strategy .
* The troop strategy can be AERIAL or GROUND . If AERIAL is choosen more troops are allocated for the archers and if GROUND is choosen more troops are allocated to swordsmen/spearmen.
# Futuer enhancements
 * Right now the library only supports three types of soldiers but this design can be extended to support more types in the future.
 * Also the assumeption is made that user calls the constructor with some weights, there can be helpful libraray methods can be predefined with  example weight functions in future.
# Running the code
 ```mvn clean package```