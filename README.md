# GitHub Copilot in IntelliJ IDEA: Advanced Java Workshop

Welcome to the **GitHub Copilot Developer Training (Intermediate)** workshop!  
This repo is showcasing how GitHub Copilot can supercharge your workflows inside **IntelliJ IDEA**.

## What’s Inside

A hands-on set of Java exercises built to:
Demonstrate GitHub Copilot’s power in **real coding workflows** 
---

## Prerequisites

Make sure you’ve got the following:

- [IntelliJ IDEA](https://www.jetbrains.com/idea/download/)
- GitHub Copilot plugin (install via **IntelliJ Plugin Marketplace**)
- GitHub account with Copilot access
- Java OpenJDK 22

---

## Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/dminkovski/ghcp-advanced-javaintellij.git
cd ghcp-advanced-javaintellij
```

### 2. Open the Project

- Launch IntelliJ IDEA
- Open the cloned folder as a new project
- Let IntelliJ import Gradle (if prompted)

### 3. Configure the JDK

Go to:  
**File > Project Structure > Project**  
Set the **Project SDK** to your installed JDK version (Java 11+ recommended)

### 4. Enable GitHub Copilot

- Go to **Preferences > Plugins**
- Search for **GitHub Copilot**, install and restart IntelliJ
- Log in with your GitHub account when prompted

---

## Copilot in IntelliJ – Pro Tips

- **Code Completion**: Start typing and Copilot will suggest completions inline
    **Comment First**: Write a comment like  
  ```// create a user service```  
  Then press enter and Copilot will do the rest
- **See More Options**: Press \`Alt + ]\` or \`Alt + [\` (or \`Cmd\` on Mac) to cycle suggestions
- **Generate Tests**: Ask Copilot to write unit tests based on your function names
- **Refactor with AI**: Let Copilot suggest smarter alternatives for your logic

---

## Sample Prompt Ideas

```bash
// generate a method that filters a list of strings by length and sorts alphabetically
```

```bash
// write a user service that returns a list of users
```

```bash
// implement the Factory design pattern for creating Users
```

---

## Contributing

Got ideas for more exercises? Found a bug?  
PRs are welcome! Fork it, improve it, and submit your suggestions.