# 🦷 Projeto Odontológico - Sprint 4

Este projeto é uma aplicação web desenvolvida com Spring Boot que visa o gerenciamento de pacientes de um consultório odontológico. Ele contempla funcionalidades como cadastro, edição, exclusão e listagem de pacientes, além de recursos modernos como autenticação, internacionalização, mensageria e monitoramento.

## ✅ Funcionalidades

- 👤 **Autenticação com Spring Security**
  - Login com usuário `admin` e senha `1234`
  - Gestão de perfis de acesso (ROLE_ADMIN)
  - Proteção de rotas (apenas usuários autenticados acessam o sistema)

- 🌍 **Internacionalização (i18n)**
  - Suporte a múltiplos idiomas com `messages.properties`
  - Pode ser estendido para inglês, espanhol, etc.

- ✉️ **Mensageria com Spring (Producer/Consumer)**
  - Implementação de produtor e consumidor de mensagens
  - Simulação de troca de mensagens via fila

- 📊 **Monitoramento com Spring Boot Actuator**
  - Monitoramento da aplicação via endpoints como:
    - `/actuator/health`
    - `/actuator/info`
    - `/actuator/metrics`

- 🧠 **Inteligência Artificial com Spring AI**
  - Implementação de um recurso de IA (ex: sugestão de procedimentos)
  - Integração com LLMs via Spring AI

## 📚 Tecnologias Utilizadas

- Java 20
- Spring Boot
- Spring Security
- Spring Web
- Thymeleaf
- Spring AI
- Spring Boot Actuator
- Spring Messaging
- Maven ou Gradle
- Git e GitHub

## 🔐 Acesso ao sistema

| Usuário | Senha  | Perfil     |
|---------|--------|------------|
| admin   | 1234   | ROLE_ADMIN |

## 🚀 Como executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/SEU_USUARIO/NOME_DO_REPOSITORIO.git
   cd NOME_DO_REPOSITORIO
   ```

2. Rode o projeto:
   ```bash
   ./gradlew bootRun
   ```
   ou pelo IntelliJ/Eclipse com botão de "Run"

3. Acesse:  
   ```
   http://localhost:8080/login
   ```

4. Use o login:  
   - Usuário: `admin`  
   - Senha: `1234`

## 📁 Estrutura do Projeto

```
src
├── main
│   ├── java
│   │   └── com.sprint.Sprint3
│   │       ├── controller
│   │       ├── config
│   │       ├── model
│   │       └── repository
│   ├── resources
│   │   ├── templates (Thymeleaf HTML)
│   │   ├── static (CSS/JS)
│   │   ├── messages.properties
│   │   └── application.properties
```

## ✨ Autor

Desenvolvido por Gustavo Rocha Caxias 🚀  
Aluno do curso de Análise e Desenvolvimento de Sistemas  
RM: 553310
