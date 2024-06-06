package main

import (
	"encoding/json"
	"fmt"
	"net/http"
)


type Carro struct{
	Nome string
	Modelo string
	Ano int
}

func (c Carro) Andar(){
	fmt.Println("O carro, " + c.Nome + "está andando")
}

func main(){

	http.HandleFunc("/", )
	http.ListenAndServe(":3333", nil)
}

func home(w http.ResponseWriter, r *http.Request) {
	carro1 := Carro{Nome: "Astra", Modelo: "CD", Ano: 2004}
	carro1.Andar()

	json.NewEncoder(w).Encode(carro1)
}