# IMC-pos-moveis-2026

Um aplicativo Android moderno para cálculo de Índice de Massa Corporal (IMC), desenvolvido como parte de um projeto de pós-graduação em desenvolvimento móvel.

## 🚀 Funcionalidades

- **Cálculo de IMC Automático:** Suporta tanto o sistema métrico (kg/m) quanto o sistema imperial (lb/in), detectando automaticamente o idioma do sistema.
- **Internacionalização (i18n):** Totalmente traduzido para Português (PT-BR) e Inglês (EN).
- **Validação de Dados:** Tratamento de erros para campos vazios e divisão por zero com mensagens amigáveis ao usuário.
- **Interface Intuitiva:** Design limpo utilizando Material Design 3, com suporte a Edge-to-Edge.
- **Interações Adicionais:** 
    - Clique longo no botão calcular para dicas de uso.
    - Função de limpar campos para novos cálculos.

## 🛠️ Tech Stack

- **Linguagem:** [Kotlin](https://kotlinlang.org/)
- **UI:** [XML / Material Design 3](https://m3.material.io/)
- **Arquitetura:** Componentes do Android Jetpack (AppCompat, Activity-KTX, ConstraintLayout).
- **Testes:** 
    - Unitários: JUnit 4.
    - UI/Instrumentados: Espresso.
- **Build System:** Gradle com Version Catalogs (libs.versions.toml).

## 🧪 Testes

O projeto possui uma suíte de testes robusta:

### Testes Unitários
Testam a lógica matemática de cálculo do IMC para diferentes regiões.
Localização: `app/src/test/java/com/example/imc_pos_moveis_2026/ExampleUnitTest.kt`

### Testes de UI (Instrumentados)
Simulam o comportamento do usuário e validam as mensagens de erro na tela.
Localização: `app/src/androidTest/java/com/example/imc_pos_moveis_2026/MainActivityTest.kt`

## 📦 Instalação

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/IMC-pos-moveis-2026.git
   ```
2. Abra o projeto no **Android Studio (Ladybug ou superior)**.
3. Sincronize o Gradle.
4. Execute o aplicativo em um emulador ou dispositivo físico com Android 7.0 (API 24) ou superior.

---
Desenvolvido com ❤️ como parte de estudos em desenvolvimento Android.
