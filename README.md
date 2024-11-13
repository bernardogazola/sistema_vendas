# Sistema de Gestão de Vendas

### Trabalho desenvolvido durante o terceiro período do curso de Engenharia de Software da PUC-PR para a disciplina de Programação Orientada a Objetos

---

## 📄 Sobre o Projeto

Este projeto é um sistema de gestão de vendas desenvolvido em **Java**, com interfaces gráficas utilizando **Swing** e persistência de dados em arquivos. O objetivo é proporcionar um ambiente de controle de vendas, estoque e usuários (gerentes e vendedores), simulando o funcionamento básico de um sistema de vendas utilizado em ambientes comerciais.

---

## 🎯 Funcionalidades

### Gerente
- **Cadastro de Clientes**: Permite que o gerente cadastre novos clientes no sistema.
- **Gerenciamento de Estoque**: Adicionar produtos, atualizar quantidades em estoque e visualizar a lista de produtos.
- **Gestão de Vendedores**: Cadastro de novos vendedores e visualização do histórico de vendas de qualquer vendedor.
- **Visualização de Perfil**: Exibe informações detalhadas sobre o gerente, incluindo comissão e total de vendas realizadas.
- **Histórico de Vendas**: Acesso ao histórico de vendas do próprio gerente e de outros vendedores.

### Vendedor
- **Cadastro de Clientes**: Permite que o vendedor cadastre novos clientes no sistema.
- **Realizar Venda**: Seleção de clientes e produtos com cálculo automático do subtotal e atualização do estoque.
- **Histórico de Vendas**: Visualização do histórico de vendas realizadas pelo próprio vendedor.
- **Visualização de Perfil**: Exibe as informações pessoais do vendedor, o total de vendas e a meta mensal, com progresso e status.

### Autenticação e Acesso
- Sistema de login que diferencia o acesso e permissões entre gerentes e vendedores, permitindo funcionalidades específicas para cada tipo de usuário.

---

## ⚙️ Tecnologias Utilizadas

- ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
- **Java Swing** - Para construção das interfaces gráficas.
- **Arquivos de Texto (.txt)** - Persistência de dados.

---

## 📂 Estrutura de Dados e Persistência

Os dados são armazenados em arquivos `.txt`, organizados por tipo de informação:
- `clientes.txt`: Armazena dados de clientes.
- `produtos.txt`: Gerencia o estoque de produtos.
- `vendas.txt` e `itensVendas.txt`: Registra vendas e os itens vendidos.
- `logins.txt`: Armazena credenciais e permissões dos usuários.

Cada tipo de dado é gerenciado pelo seu respectivo `FileManager`, facilitando a leitura, escrita e atualização de informações.

---

## 👥 Contribuidores
![Contribuidores](https://img.shields.io/badge/Contribuidores-3-blue)
- [Bernardo](https://github.com/bernardogazola)
- [Icaro](https://github.com/IcaroAles)
- [Otávio](https://github.com/taviogus)

---

> Projeto desenvolvido para fins educacionais. Todos os dados e funcionalidades simulam um sistema real, mas foram implementados exclusivamente para a disciplina de Programação Orientada a Objetos.

