package org.study.demo.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @Author: SongTC
 * @Since: 2022/11/12
 * @E-mail: 690259811@qq.com
 * @Details;
 */

@CrossOrigin
@RestController
public class HelloWorldController {

    @GetMapping("/getMsg")
    public String getMsg(String msg) {
        if ("songTc".equals(msg)) {
            return "                   ,----,\n" +
                    "                 ,/   .`|\n" +
                    "  .--.--.      ,`   .'  :                ,---,\n" +
                    " /  /    '.  ;    ;     /       ,--,   .'  .' `\\         ,---,\n" +
                    "|  :  /`. /.'___,/    ,'      ,'_ /| ,---.'     \\       /_ ./|\n" +
                    ";  |  |--` |    :     |  .--. |  | : |   |  .`\\  |,---, |  ' :\n" +
                    "|  :  ;_   ;    |.';  ;,'_ /| :  . | :   : |  '  /___/ \\.  : |\n" +
                    " \\  \\    `.`----'  |  ||  ' | |  . . |   ' '  ;  :.  \\  \\ ,' '\n" +
                    "  `----.   \\   '   :  ;|  | ' |  | | '   | ;  .  | \\  ;  `  ,'\n" +
                    "  __ \\  \\  |   |   |  ':  | | :  ' ; |   | :  |  '  \\  \\    '\n" +
                    " /  /`--'  /   '   :  ||  ; ' |  | ' '   : | /  ;    '  \\   |\n" +
                    "'--'.     /    ;   |.' :  | : ;  ; | |   | '` ,/      \\  ;  ;\n" +
                    "  `--'---'     '---'   '  :  `--'   \\;   :  .'         :  \\  \\\n" +
                    "                       :  ,      .-./|   ,.'            \\  ' ;\n" +
                    "@BY songTc             `--`----'    '---'               `--`\n";
        }
        return "songTc";
    }

    @PostMapping("/postMsg")
    public String postMsg(@RequestBody HelloRo helloRo) {
        if ("songTc".equals(helloRo.msg)) {
            return "                   ,----,\n" +
                    "                 ,/   .`|\n" +
                    "  .--.--.      ,`   .'  :                ,---,\n" +
                    " /  /    '.  ;    ;     /       ,--,   .'  .' `\\         ,---,\n" +
                    "|  :  /`. /.'___,/    ,'      ,'_ /| ,---.'     \\       /_ ./|\n" +
                    ";  |  |--` |    :     |  .--. |  | : |   |  .`\\  |,---, |  ' :\n" +
                    "|  :  ;_   ;    |.';  ;,'_ /| :  . | :   : |  '  /___/ \\.  : |\n" +
                    " \\  \\    `.`----'  |  ||  ' | |  . . |   ' '  ;  :.  \\  \\ ,' '\n" +
                    "  `----.   \\   '   :  ;|  | ' |  | | '   | ;  .  | \\  ;  `  ,'\n" +
                    "  __ \\  \\  |   |   |  ':  | | :  ' ; |   | :  |  '  \\  \\    '\n" +
                    " /  /`--'  /   '   :  ||  ; ' |  | ' '   : | /  ;    '  \\   |\n" +
                    "'--'.     /    ;   |.' :  | : ;  ; | |   | '` ,/      \\  ;  ;\n" +
                    "  `--'---'     '---'   '  :  `--'   \\;   :  .'         :  \\  \\\n" +
                    "                       :  ,      .-./|   ,.'            \\  ' ;\n" +
                    "@BY songTc             `--`----'    '---'               `--`\n";
        }
        return "songTc";
    }
}

class HelloRo {
    public String msg;
}