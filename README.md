
# Ambiente 
Execute o  **docker-compose -f docker-compose-kafka.yml up -d** para inicializar o Zookeeper e Kafka.

![image](https://user-images.githubusercontent.com/37228699/212746503-f3823746-2c65-4943-a727-e0d2993897d3.png)

Mensagem enviada para o tópico de VOTO no Kafka, de forma direta pelo producer, o mesmo será lido pelo nosso consumer, como no log abaixo:

###### **Enviando:**
![image](https://user-images.githubusercontent.com/37228699/212748597-3f64b99a-29a4-4cf1-8bd3-331fd1442fd5.png)


###### **Recebendo:**
![image](https://user-images.githubusercontent.com/37228699/212747036-3a440cb2-e433-4856-9ca5-5d7b43e3f4a9.png)

#  API REST

Link local: http://localhost:8080/swagger-ui.html
Link local banco: http://localhost:8080/h2-console

![image](https://user-images.githubusercontent.com/37228699/210102680-b0faeff8-a0fb-42f2-96a9-8decea9e19b4.png)


# Considerações:

* O parâmetro (header) **Token de autorização** pode ser qualquer número, exemplo 10.
* Foi utilizado o **banco de dados H2** como forma rápida e simples para armanezar os dados 
* Foi utilizado o Eclipse Java EE para desenvolver a **API REST**
* O mesmo é um projeto **maven** 
* Foi foi a **integração com a API** para validar o CPF mas o mesmo provavelmente está fora, então deixei a chamada comentada 
* Foi feito alguns **testes unitarios** 
* Foi utilizado **Kafka** 
* Foi utilizado **Java 8** 
* Foi utilizado **Spring boot** 
* Foi utilizado **jUnit** 
* Foi utilizado **lombok** 
* Foi utilizado **FeignClient**
* Foi utilizado **swagger**

# Exemplo de algumas validações: 

![image](https://user-images.githubusercontent.com/37228699/210086590-7a7b1b6b-38d4-4119-8128-54ab93a6399d.png)
![image](https://user-images.githubusercontent.com/37228699/210087108-7ef10799-49d0-48dc-97ec-0490b5880537.png)


# Estruta base do projeto:

```
votacao-app
votacao-impl
	src/main/java
		/br/com/sicredi
			votacao
				api.v1
					DTOs
					Rest	
				business
					Converters
					PautaService
					VotacaoService
				infrastructure
					Client
					Entity
					Enums
					Repository
					Config
		resources/db/migration
			V2__CREATE_TABLE
			V3__CREATE_TABLE
```

