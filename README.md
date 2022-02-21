# Conatus
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/jonassantos1000/Conatus-SpringBoot-Java-8-PostGree/blob/main/LICENSE) 

# Sobre o Projeto

Conatus é um sistema corporativo gerencial, desenvolvido com a tecnologia SpringBoot e integrado com o banco de dados PostGreeSQL.

Orientações em Portugues:

# Como utilizar a API Conatus

É possivel testar online os endpoints da API através do Heroku, pelo link a seguir: https://conatus-pg.herokuapp.com

Endpoints diponiveis para serem testados:
- client
- orders
- products
- users
- employees
- counters
- settings

Exemplos de utilização de cada endpoint:

## Client

  Post:
	
    Url Requisição: https://conatus-pg.herokuapp.com/client
		
    Exemplo Json:
		
      {
        "codigo": 6,
        "nome": "TESTE HEROKU5",
        "cpf": "111.111.111-11",
        "celular": "(11) 11111-1111",
        "email": "HEROKU@GMAIL.COM",
        "data_cadastro": "2022-02-20 20:45:57",
        "data_alteracao": "2022-02-20 20:47:29",
        "rg": "11.111.111-1",
        "endereco": "RUA FERNAO DIAS",
        "bairro": " VILA MARIA",
        "numero": "11",
        "cep": "11111-111",
        "complemento": "AVENIDA",
        "telefone": "(11) 1111-1111",
        "observacao": "TESTANDO API C/ HEROKU",
        "notificaEmail": "F"
      }
			
  Put:
	
    Url Requisição: https://conatus-pg.herokuapp.com/clients/"id que irá alterar"
    
    Ex: https://conatus-pg.herokuapp.com/clients/6
		
    Exemplo Json:
		
    {
        "codigo": 6,
        "nome": "TESTE PUT API",
        "cpf": "111.111.111-11",
        "celular": "(11) 11111-1111",
        "email": "HEROKU@GMAIL.COM",
        "data_cadastro": "2022-02-20 20:45:57",
        "data_alteracao": "2022-02-20 20:47:29",
        "rg": "11.111.111-1",
        "endereco": "RUA FERNAO DIAS",
        "bairro": " VILA MARIA",
        "numero": "11",
        "cep": "11111-111",
        "complemento": "AVENIDA",
        "telefone": "(11) 1111-1111",
        "observacao": "TESTANDO PUT NA API C/ HEROKU",
        "notificaEmail": "F"
      }
      
  Delete:
   ```
    Url Requisição: https://conatus-pg.herokuapp.com/clients/"id que irá excluir"
    
    Ex: https://conatus-pg.herokuapp.com/clients/6		 
   ``` 
   
  Get:
   ```
	  Find by Id:
		 
      Url Requisição: https://conatus-pg.herokuapp.com/clients/"id que irá buscar"

      Ex: https://conatus-pg.herokuapp.com/clients/6
     
     
      Find All:

      Url Requisição: https://conatus-pg.herokuapp.com/clients

      Ex: https://conatus-pg.herokuapp.com/clients
		
    
      Find Custom:

      @RequestParam(value="id", required=false) Long id,

      @RequestParam(value="nome", required=false) String name,

      @RequestParam(value="cpf", required=false) String cpf,

      @RequestParam(value="rg", required=false) String rg,

      @RequestParam(value="email", required=false) String email,

      @RequestParam(value="limite", required=true) String limite) -> limita a quantidade de registros que irá retornar na consulta, parametro obrigatório.

      Url Requisição: https://conatus-pg.herokuapp.com/clients/custom?"Nome do parametro"="valor do parametro"

      Ex: Url Requisição: https://conatus-pg.herokuapp.com/clients/custom?nome=jonas&limite=100
   ```
     
   
   
   # Autor 
     
     Jonas Santos do Vale Silva
     
     https://www.linkedin.com/in/jonas-santos-15a64a179
  
