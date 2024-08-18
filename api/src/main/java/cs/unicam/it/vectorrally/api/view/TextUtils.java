/*
 * Copyright <2024> <Niccolò Lucozzi>
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 *
 */

package cs.unicam.it.vectorrally.api.view;

public interface TextUtils {

    static void printCustomText(String text) {
        System.out.print(text);
    }

    static void printCustomText(String text, Color color) {
        System.out.print(color + text + Color.RESET);
    }

    static void printCustomlnText(String text) {
        System.out.println(text);
    }

    static void printCustomlnText(String text, Color color) {
        System.out.println(color + text + Color.RESET);
    }

    static void clearScreen() {
        System.out.print("\033[H\033[2J");
    }

    static void printGameLogo() {
        System.out.println(Color.RED + """
                __/\\\\\\________/\\\\\\_____________________________________________________________________________________/\\\\\\\\\\\\\\\\\\_____________________/\\\\\\\\\\\\_____/\\\\\\\\\\\\__________________       \s
                 _\\/\\\\\\_______\\/\\\\\\___________________________________________________________________________________/\\\\\\///////\\\\\\__________________\\////\\\\\\____\\////\\\\\\__________________      \s
                  _\\//\\\\\\______/\\\\\\___________________________________/\\\\\\____________________________________________\\/\\\\\\_____\\/\\\\\\_____________________\\/\\\\\\_______\\/\\\\\\_______/\\\\\\__/\\\\\\_     \s
                   __\\//\\\\\\____/\\\\\\_______/\\\\\\\\\\\\\\\\______/\\\\\\\\\\\\\\\\__/\\\\\\\\\\\\\\\\\\\\\\_____/\\\\\\\\\\_____/\\\\/\\\\\\\\\\\\\\____________\\/\\\\\\\\\\\\\\\\\\\\\\/_____/\\\\\\\\\\\\\\\\\\_______\\/\\\\\\_______\\/\\\\\\______\\//\\\\\\/\\\\\\__    \s
                    ___\\//\\\\\\__/\\\\\\______/\\\\\\/////\\\\\\___/\\\\\\//////__\\////\\\\\\////____/\\\\\\///\\\\\\__\\/\\\\\\/////\\\\\\___________\\/\\\\\\//////\\\\\\____\\////////\\\\\\______\\/\\\\\\_______\\/\\\\\\_______\\//\\\\\\\\\\___   \s
                     ____\\//\\\\\\/\\\\\\______/\\\\\\\\\\\\\\\\\\\\\\___/\\\\\\____________\\/\\\\\\_______/\\\\\\__\\//\\\\\\_\\/\\\\\\___\\///____________\\/\\\\\\____\\//\\\\\\_____/\\\\\\\\\\\\\\\\\\\\_____\\/\\\\\\_______\\/\\\\\\________\\//\\\\\\____  \s
                      _____\\//\\\\\\\\\\______\\//\\\\///////___\\//\\\\\\___________\\/\\\\\\_/\\\\__\\//\\\\\\__/\\\\\\__\\/\\\\\\___________________\\/\\\\\\_____\\//\\\\\\___/\\\\\\/////\\\\\\_____\\/\\\\\\_______\\/\\\\\\_____/\\\\_/\\\\\\_____ \s
                       ______\\//\\\\\\________\\//\\\\\\\\\\\\\\\\\\\\__\\///\\\\\\\\\\\\\\\\____\\//\\\\\\\\\\____\\///\\\\\\\\\\/___\\/\\\\\\___________________\\/\\\\\\______\\//\\\\\\_\\//\\\\\\\\\\\\\\\\/\\\\__/\\\\\\\\\\\\\\\\\\__/\\\\\\\\\\\\\\\\\\_\\//\\\\\\\\/______\s
                        _______\\///__________\\//////////_____\\////////______\\/////_______\\/////_____\\///____________________\\///________\\///___\\////////\\//__\\/////////__\\/////////___\\////________
                """ + Color.RESET);
    }
}
