# Notepad Application 📝

This is a **native Java** implementation of a lightweight **Notepad** application. It features a simple yet functional graphical user interface (GUI) built using `Swing`, allowing users to create, edit, save, and open text files.

---

## 🖼️ Demo

### Application Screenshot:
[![ Note Screenshot](capture/Pic.png)](capture/NoteVid.mp4)
> *Click the image above to watch the video demo.*

---

## 🚀 How to Use
### Prerequisites
- [**Java Development Kit (JDK)**](https://www.oracle.com/java/technologies/downloads/) installed (version 8 or higher)

1. Open your terminal and clone the repository:
```bash
git clone https://github.com/Omid2831/NotePad.git
```
2. Navigate into the project directory:
```bash
cd NotePad
```
### Compile and Run
1. Compile the source files and place the compiled classes in the `bin` directory:
``` bash
javac -d bin *.java
```
3. Run the program:
```bash
java -cp bin Notepad.java
```
(Please make sure Notepad.java is your program's entry point.)  
---
### 🛠️ File Structure

<pre> 📂 Notepad-App ├── src/ │ └── main/ │ └── java/ │ ├── Main.java# Main entry point of the application │ └── NotePad.java# NotePad functionality implementation ├── bin/ │ ├── Main.class# Compiled bytecode for Main │ └── NotePad.class# Compiled bytecode for NotePad ├── 📂 capture │ ├── NoteVid.mp4 # Video demo of the application │ └── Pic.png# Screenshot of the application </pre>
