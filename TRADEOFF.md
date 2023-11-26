### Trade-offs:

## Monolito vs. Microserviços:

###  **Opção:**

Utilizar um sistema monolítico em vez de adotar uma arquitetura de microserviços.

### **Justificativa:**

Dada a natureza de pequeno porte da solução e a expectativa de baixa sobrecarga de requests, optou-se por um sistema monolítico para simplificar o desenvolvimento, implantação e manutenção.

**Consequências:**
- **Simplicidade no Desenvolvimento e Manutenção:** A abordagem monolítica simplifica o processo de desenvolvimento e manutenção, pois todas as funcionalidades estão integradas em um único sistema.
- **Menor Overhead de Gerenciamento:** A gestão de um único sistema é menos complexa em comparação com vários microserviços, economizando esforços em operações e monitoramento.
- **Custos Iniciais Menores:** A implementação de um monolito geralmente exige menos recursos e esforços iniciais do que uma arquitetura de microserviços.
- **Sobrecarga de Requests Limitada:** Dada a previsão de pouca sobrecarga de requests, a abordagem monolítica é considerada suficiente para atender aos requisitos de desempenho sem a necessidade de escalabilidade horizontal proporcionada por microserviços.

-------

## Sistema de Autenticação Simplificado:


### **Opção:** 
Não implementar um sistema de autenticação robusto.


### **Justificativa:** 

O projeto não inclui um sistema de login, uma vez que os esforços foram direcionados para outras entregas de valor. Além disso, trata-se de um sistema destinado a uma equipe ou empresa específica, não sendo uma aplicação SaaS.

**Consequências:**
- **Rapidez no Desenvolvimento:** A ausência de um sistema de autenticação complexo permite um desenvolvimento mais rápido de outras funcionalidades centrais do sistema.
- **Menor Sobrecarga para Usuários:** A falta de autenticação simplifica a experiência do usuário, eliminando a necessidade de criar e gerenciar contas.
- **Menor Custo Inicial:** A não implementação de um sistema de autenticação robusto pode resultar em custos iniciais mais baixos.
- **Foco em Entregas de Valor:** O projeto direciona os esforços para funcionalidades mais centrais, priorizando a entrega de valor imediato para os usuários finais em detrimento da complexidade de um sistema de autenticação.

[Voltar](README.md)