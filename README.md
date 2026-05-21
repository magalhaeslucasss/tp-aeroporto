# Simulação de Aeroporto ✈️

Projeto desenvolvido para a disciplina de Estrutura de Dados.

## 📌 Objetivo

O objetivo do projeto é simular o funcionamento de um aeroporto utilizando estruturas de dados do tipo fila (FIFO), controlando:

- pousos;
- decolagens;
- gerenciamento de pistas;
- filas de espera;
- emergências por falta de combustível;
- estatísticas do aeroporto.

---

## ⚙️ Funcionalidades

- Filas FIFO para pouso e decolagem
- Controle de combustível das aeronaves
- Sistema de emergência
- Balanceamento automático das filas
- Controle de 3 pistas
- Estatísticas de tempo médio de espera
- Simulação por unidades de tempo

---

## 🛠️ Tecnologias Utilizadas

- Java
- Programação Orientada a Objetos (POO)
- Estruturas de Dados
- Git e GitHub

---

## 📂 Estrutura do Projeto

```txt
tp-aeroporto/
│
├── Aeroporto.java
├── Aviao.java
├── FilaAvioes.java
├── Pista.java
├── Main.java
└── README.md
```

---

## ▶️ Como Executar

Compile os arquivos:

```bash
javac *.java
```

Execute:

```bash
java Main
```

---

## 🧪 Testes Realizados

- Inserção e remoção em filas FIFO
- Balanceamento das filas
- Controle de combustível
- Emergências
- Operação normal das pistas
- Simulação de stress
- Cálculo de estatísticas

---

## 📊 Exemplo de Saída

```txt
======================
TEMPO 1
======================

Novo avião POUSO ID 1 Combustível 5
Novo avião DECOLAGEM ID 2

Pista 1 -> POUSO do avião 1
Pista 3 -> DECOLAGEM do avião 2
```

---

## 👨‍💻 Autor

Lucas Magalhães

Projeto acadêmico desenvolvido para fins educacionais.