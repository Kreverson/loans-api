# loans-api
Analyzes the customer profile and returns which types of loans are avaiable


# Empréstimos
Implementado um serviço que determine quais modalidades de empréstimo uma pessoa tem acesso.

# Exemplo
As modalidades de empréstimo disponíveis são:

* Empréstimo pessoal: Taxa de juros de 4%.
*  Empréstimo consignado: Taxa de juros de 2%.
* Empréstimo com garantia: Taxa de juros de 3%.
* As modalidades de empréstimo disponíveis para uma pessoa são baseadas em algumas variáveis específicas, são elas:

- Idade
- Salário
- Localização

O serviço recebe uma chamada para determinar quais modalidades de empréstimo uma pessoa tem acesso.

[POST] ```{{host}}/customer-loans```

```
{
    "age": 26,
    "cpf": "275.484.389-23",
    "name": "Vuxaywua Zukiagou",
    "income": 7000.00,
    "location": "SP"
}
```
O serviço retorna uma resposta contendo o nome do cliente e uma lista de empréstimos aos quais ele tem acesso, com os respectivos tipos e taxas de juros.

```HTTP/1.1 200 Ok```

```
{
    "customer": "Vuxaywua Zukiagou",
    "loans": [
        {
            "type": "PERSONAL",
            "interest_rate": 4
        },
        {
            "type": "GUARANTEED",
            "interest_rate": 3
        },
        {
            "type": "CONSIGNMENT",
            "interest_rate": 2
        }
    ]
}
```

# Requisitos
* Conceder o empréstimo pessoal se o salário do cliente for igual ou inferior a R$ 3000.
* Conceder o empréstimo pessoal se o salário do cliente estiver entre R$ 3000 e R$ 5000, se o cliente tiver menos de 30 anos e residir em São Paulo (SP).
* Conceder o empréstimo consignado se o salário do cliente for igual ou superior a R$ 5000.
* Conceder o empréstimo com garantia se o salário do cliente for igual ou inferior a R$ 3000.
* Conceder o empréstimo com garantia se o salário do cliente estiver entre R$ 3000 e R$ 5000, se o cliente tiver menos de 30 anos e residir em São Paulo (SP).

# Referência
https://github.com/backend-br/desafios
