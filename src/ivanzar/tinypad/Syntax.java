package ivanzar.tinypad;

import org.fife.ui.rsyntaxtextarea.SyntaxConstants;

/**
 *
 * @author ivanzar
 */
public class Syntax {
    
    /** 
     * @param file
     * @return
     */
    public static String getSyntax(String file){
        
        if(file.endsWith(".as")) return SyntaxConstants.SYNTAX_STYLE_ACTIONSCRIPT;
        if(file.endsWith(".asm")) return SyntaxConstants.SYNTAX_STYLE_ASSEMBLER_X86;
        if(file.endsWith(".fla")||file.endsWith(".swf")) return SyntaxConstants.SYNTAX_STYLE_BBCODE;
        if(file.endsWith(".c")) return SyntaxConstants.SYNTAX_STYLE_C;
        if(file.endsWith(".clj")) return SyntaxConstants.SYNTAX_STYLE_CLOJURE;
        if(file.endsWith(".cpp") || file.endsWith(".h") || file.endsWith(".ino")) return SyntaxConstants.SYNTAX_STYLE_CPLUSPLUS;
        if(file.endsWith(".cs")) return SyntaxConstants.SYNTAX_STYLE_CSHARP;
        if(file.endsWith(".css")) return SyntaxConstants.SYNTAX_STYLE_CSS;
        if(file.endsWith(".d")) return SyntaxConstants.SYNTAX_STYLE_D;
        if(file.endsWith(".dart")) return SyntaxConstants.SYNTAX_STYLE_DART;
        if(file.endsWith(".pas") || file.endsWith(".dpr") || file.endsWith(".dpk") || file.endsWith(".pp"))
            return SyntaxConstants.SYNTAX_STYLE_DELPHI;
        if(file.endsWith(".dtd")) return SyntaxConstants.SYNTAX_STYLE_DTD;
        if(file.endsWith(".for") || file.endsWith(".f") || file.endsWith(".f90") || file.endsWith(".f95"))
            return SyntaxConstants.SYNTAX_STYLE_FORTRAN;
        if(file.endsWith(".groovy")) return SyntaxConstants.SYNTAX_STYLE_GROOVY;
        if(file.endsWith(".host")) return SyntaxConstants.SYNTAX_STYLE_HOSTS;
        if(file.endsWith(".htaccess")) return SyntaxConstants.SYNTAX_STYLE_HOSTS;
        if(file.endsWith(".html")) return SyntaxConstants.SYNTAX_STYLE_HTML;
        if(file.endsWith(".java")) return SyntaxConstants.SYNTAX_STYLE_JAVA;
        if(file.endsWith(".js")) return SyntaxConstants.SYNTAX_STYLE_JAVASCRIPT;
        if(file.endsWith(".jshintrc")) return SyntaxConstants.SYNTAX_STYLE_JSHINTRC;
        if(file.endsWith(".json")) return SyntaxConstants.SYNTAX_STYLE_JSON;
        if(file.endsWith(".jsp")) return SyntaxConstants.SYNTAX_STYLE_JSP;
        if(file.endsWith(".lua")) return SyntaxConstants.SYNTAX_STYLE_LUA;
        else return "text/plain";
    }
    
}
