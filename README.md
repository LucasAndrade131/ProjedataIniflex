# 💻 Desafio Técnico - Projedata (Iniflex)

## 📌 Sobre o projeto

Este projeto foi desenvolvido como parte de um desafio técnico, com o objetivo de manipular e exibir informações de funcionários utilizando Java.

Foram aplicados conceitos de:

* Programação Orientada a Objetos (POO)
* Collections (List, Map)
* Stream API
* Manipulação de datas (`LocalDate`, `Period`)
* Formatação de dados (datas e valores monetários)
* Boas práticas de organização de código

---

## ✅  Requisitos implementados

| # | Requisito |
|---|-----------|
| 1 | Classe `Pessoa` com `nome` (String) e `dataNascimento` (LocalDate) |
| 2 | Classe `Funcionario` estendendo `Pessoa`, com `salario` (BigDecimal) e `funcao` (String) |
| 3.1 | Inserção de todos os funcionários na ordem da tabela fornecida |
| 3.2 | Remoção do funcionário **João** da lista |
| 3.3 | Impressão formatada: data em `dd/MM/yyyy`, valores com `.` milhar e `,` decimal |
| 3.4 | Aumento de **10%** no salário de todos os funcionários |
| 3.5 | Agrupamento por função em um `Map<String, List<Funcionario>>` |
| 3.6 | Impressão dos funcionários agrupados por função |
| 3.8 | Impressão dos aniversariantes dos meses **10 (Outubro)** e **12 (Dezembro)** |
| 3.9 | Identificação e impressão do funcionário **mais velho** (nome e idade) |
| 3.10 | Listagem dos funcionários em **ordem alfabética** |
| 3.11 | Cálculo e impressão do **total de salários** |
| 3.12 | Impressão de quantos **salários mínimos** (R$ 1.212,00) cada funcionário recebe |

---

## 🧪 Tecnologias utilizadas

* Java 17+

* Spring Boot (exclusivamente para execução via `CommandLineRunner`)
* Maven


## ▶️ Como executar o projeto

### 🔹 Clonar o repositório

```bash
git clone https://github.com/LucasAndrade131/ProjedataIniflex.git
```

### 🔹 Executar com Maven

```bash
./mvnw spring-boot:run
```

---

### 🔹 Ou Gerar e executar o JAR

```bash
mvn clean package -DskipTests
```

```bash
java -jar target/projedata-desafio-0.0.1-SNAPSHOT.jar
```

---

## 📊 Saída do programa

O sistema exibe:

* Lista de funcionários formatada
* Agrupamento por função
* Funcionários aniversariantes
* Funcionário mais velho
* Ordenação alfabética
* Total dos salários
* Equivalente em salários mínimos

---

## 🧠 Observações

* Foi utilizada a classe `BigDecimal` para cálculos financeiros, evitando problemas de precisão.
* A formatação de valores segue o padrão brasileiro (R$ 1.234,56).
* A responsabilidade de cálculo de idade foi atribuída à entidade `Pessoa`, seguindo boas práticas de orientação a objetos.
* Separação de responsabilidades: lógica de negócio isolada em `FuncionarioService`, apresentação na classe principal

---

## 👨‍💻 Autor

Desenvolvido por **Lucas Andrade**  
[LinkedIn](https://www.linkedin.com/in/lucas-silva-andrade) • [GitHub](https://github.com/LucasAndrade131)