- Generate hash code
    
    ```jsx
    // NOTE: caso a string possuir espaço, o hash gerado vai ser negativo
    const generate = str => {
      var hash = 0, i, str;
      if (str.length === 0) return hash;
      for (i = 0; i < str.length; i++) {
        chr   = str.charCodeAt(i);
        hash  = ((hash << 5) - hash) + chr;
        hash |= 0; // Convert to 32bit integer
      }
      return hash;
      // return (parseInt(hash) < 0) ? hash * -1 : hash ; //--> para sempre gerar positivo (diminui a segurança)
    };
    
    console.log(generate('aaa aa'));
    ```
    
- Array of upper case and under lines to array camel case ( beta )
    
    ```jsx
    let str = "LOJA; " +
    "DATA; " +
    "NUM_PDV; " +
    "NUM_CUPOM; " +
    "TRANSACAO; " +
    "HORA; " +
    "NSU; " +
    "OPERADOR; " +
    "VENDA_BRUTA; " +
    "DESCONTOS; " +
    "CANCELAMENTOS; " +
    "RECEBIMENTOS; " +
    "TROCO; " +
    "FINALIZ_TROCO; " +
    "QT_ITENS_VENDA; " +
    "QT_ITENS_DESCONTO; " +
    "QT_ITENS_CANCEL; " +
    "CLIENTE; " +
    "NSU_INICIAL; " +
    "RESPONSAVEL; " +
    "HORA_INICIO; " +
    "HORA_FIM; " +
    "CANCELADO; " +
    "TIPOIDENTCLIENTE; " +
    "VALORIDENTCLIENTE; " +
    "CONVENIADO; " +
    "VALOR_FATURAMENTO; " +
    "CODIGOPESSOAL; " +
    "CODIGOEMPRESA; " +
    "CODIGORESPONS; " +
    "QTDEPESSOAS; " +
    "EXPORTADO; " +
    "EXPORTADOCANCELADO; " +
    "DESCONTOITEM; " +
    "DATAABERTURA; " +
    "DATAFECHAMENTO; " +
    "CPFCNPJCLIENTE; " +
    "ACRESCIMO; " +
    "TIPOACRESCIMO; " +
    "NROCCF; " +
    "PRAZO; " +
    "TIPO_VENDA; " +
    "EVENTO_CUPOM; " +
    "EVENTO_NSU; " +
    "TIPOCPFCNPJCLIENTE; " +
    "LOJAPEDIDO; " +
    "VALORIMPOSTO; " +
    "ASSINA; " +
    "NUMERODEFABRICACAO; " +
    "PONTOS; " +
    "TIPOCUPOM; " +
    "COMPANY_ID; "
    
    let str_arr = str.split(";")
    let arr = [];
    for(let x = 0; x < str_arr.length; x++){
      let name = str_arr[x];
      let nameLCase = name.toLowerCase();
      let pos_under = 0;
    
      for(let x = 0; x < nameLCase.length; x++){
        if(nameLCase.substr(x, 1) === "_"){
          pos_under = x;
          break;
        }
      }
      if(pos_under === 0 || pos_under === -1 ){
        arr[x] = nameLCase;
      }else {
        try {
          arr[x] = nameLCase.replace((nameLCase[pos_under + 1]), nameLCase[pos_under + 1].toUpperCase()).replace("_", "");
        } catch (e) {
          arr[x] = nameLCase.replace((nameLCase[pos_under + 1]), nameLCase[pos_under + 1]);
        }
      }
    
    }
    console.log("**************** antes da regra ****************");
    for (var i = 0; i < str.length; i++) {
      console.log(str[i]);
    }
    console.log("**************** depois da regra ****************");
    for (var i = 0; i < arr.length; i++) {
      console.log(arr[i]);
    }
    ```
    
- Generator functions
    
    ```jsx
    /**
     * Lazy Evaluation
     */
    
    function* generator1(){
        // any code
        yield 'Value 1';
        // any code
        yield 'Value 2';
        // any code
        yield 'Value 3';
    }
    
    // const g1 = generator1();
    
    // for(let valor of g1) {
    //     console.log(valor);
    // }
    
    // console.log(g1.next().value) // return { value: 'Value 1', done: false }
    // console.log(g1.next().value) // return Value 2
    // console.log(g1.next().value) // return Value 3
    // console.log(g1.next().value) // return undefined
    
    function* generator2(){
        let i = 0;
    
        while(true){
            yield i;
            i++;
        }
    }
    const g2 = generator2();
    
    // console.log(g2.next().value); // return 0 
    // console.log(g2.next().value); // return 1
    // console.log(g2.next().value); // return 2
    
    function* generator3(){
        yield 0;
        yield 1;
        yield 2;
    }
    
    function* generator4(){
        yield* generator3();
        yield 3;
        yield 4;
        yield 5;
    }
    
    const g4 = generator4();
    
    // for(let value of g4){
    //     console.log(value); // returns 0 | 1 | 2 | 3 | 4 | 5
    // }
    
    function* generator5(){
        yield function (){
            console.log('From y1');
        }
    
        //..
    
        yield function (){
            console.log('From y2');
        }
        
        //..
    
        yield function (){
            console.log('From y3');
        }
    }
    
    const g5 = generator5();
    const gene1 = g5.next().value;
    const gene2 = g5.next().value;
    const gene3 = g5.next().value;
    
    // gene1(); // return From y1
    // gene2(); // return From y2
    // gene3(); // return From y3
    ```
    
- Arrays with value by reference and spread operator
    
    ```jsx
    const cars = ['Camry', 'Fusion', 'i30'];
    const carsReference = cars;
    const carsSpread = [...cars];
    
    const firstRemovedCar = carsReference.shift();
    const removedCar = carsReference.pop();
    
    cars.push('320i');
    cars.unshift('cruze');
    
    console.log(cars);          // returns [ 'cruze', 'Fusion', '320i' ]
    console.log(carsReference); // returns [ 'cruze', 'Fusion', '320i' ]
    console.log(carsSpread)     // returns [ 'Camry', 'Fusion', 'i30' ]
    console.log(removedCar)     // returns 'i30'
    console.log(firstRemovedCar)// returns 'Camry'
    ```
    
- Arrays with instance
    
    ```jsx
    const names = ['Neres', 'David', 'Souza'];
    
    // works on Strings, Objects, Functions and Numbers but isn't very used
    const namesWithInstance = new Array('Neres', 'David', 'Souza'); 
    
    console.log(names);             // returns [ 'Neres', 'David', 'Souza' ]
    console.log(namesWithInstance); // returns [ 'Neres', 'David', 'Souza' ]
    ```
    
- Arrays with slice function
    
    ```jsx
    const foods = ['eggs', 'meat', 'bread', 'apple', 'orange'];
    const foodSlice = foods.slice(1, 3);
                            
    // console.log(foodSlice);         // returns [ 'meat', 'bread' ]
    ```
    
- Arrays with join function
    
    ```jsx
    const graphicsCardArray = ['gtx1660 Super', 'gtx1650', 'rtx3090', 'gt1030'];
    const graphicsCardString = graphicsCardArray.join(', ');
    
    console.log(graphicsCardString);    // returns 'gtx1660 Super, gtx1650, rtx3090, gt1030'
    ```
    
- filter function
    
    ```jsx
    // filter -> always returns an array, with same quantity of elements or less
    
    // Return numbers greater than 10
    const numbers = [5, 50, 80, 1, 2, 3, 5, 8, 7, 11, 15, 22, 27]
    const numbersGreaterThanTen = numbers.filter(n => n > 10)
    console.log(`Numbers greater than 10: ${numbersGreaterThanTen} \n`) //returns -> 50,80,11,15,22,27
    
    // Return people which the name have 5 letters or more
    // Return people with more than 50 years
    // Return people which name ends with 'a'
    const people = [
        {name: 'Luiz', years: 62},
        {name: 'Maria', years: 23},
        {name: 'Eduardo', years: 55},
        {name: 'Letícia', years: 19},
        {name: 'Rosana', years: 32},
        {name: 'Wallace', years: 47}
    ]
    
    const peopleWithBigName = people.filter(p => p.name.length >= 5)
    const peopleWithMoreThanFifty = people.filter(p => p.years > 50)
    const peopleWithNameEndsWithA = people.filter(p => p.name.endsWith('a'))
    
    console.log(`peopleWithBigName: ${JSON.stringify(peopleWithBigName)} \n`)
    console.log(`peopleWithMoreThanFifty: ${JSON.stringify(peopleWithMoreThanFifty)} \n`)
    console.log(`peopleWithNameEndsWithA: ${JSON.stringify(peopleWithNameEndsWithA)} \n`)
    ```