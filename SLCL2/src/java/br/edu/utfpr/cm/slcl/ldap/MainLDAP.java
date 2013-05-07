package br.com.ldap;

import br.edu.utfpr.cm.saa.security.LDAPManager;
import com.novell.ldap.LDAPEntry;
import com.novell.ldap.LDAPException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MainLDAP {

    public static void main(String args[]) {
        try {
            // criando o ldapSearch com os valores padrÃ£o
            LDAPManager ldapManager = new LDAPManager("172.17.2.4:389", "ou=todos,dc=utfpr,dc=edu,dc=br");

            ldapManager.connect();
            String username = "a1253840";
            String password = "";
            // realizando a busca no servidor a partir do uid de um usuario e 
            // o segundo parametro null permite o retorno de todos os atributos do usuario
            boolean result;

            String alunos[] = {
                "arethaalencar",
                "frankhelbert",
                "rcampiolo",
                "filiper",
                "paulogoncalves",
                "rogerioag",
                "radames",
                "rodrigohubner",
                "kraemer",
                "liberato",
                "ipolato",
                "reginaldo",
                "phsabo",
                "luizsantos",
                "igor",
                "andreluis",
                "anachaves",
                "igorfs",
                "lgvalentin",
                "a1279106",
                "a986151",
                "a1269160",
                "a1343904",
                "a1158031",                
                "a1259105",
                "a1344013",
                "a1111469",
                "a1344021",
                "a1345842",
                "a1309072",
                "a1321706",
                "a1265067",
                "a1321617",
                "a1142780",
                "a1142798",
                "a1321587",
                "a1267183",
                "a1343920",
                "a1341375",
                "a1322168",
                "a1341391",
                "a1298941",
                "a1198572",
                "a1322222",
                "a1142844",
                "a1190784",
                "a1190792",
                "a1278380",                
                "a1215590",
                "a1345915",
                "a1341880",
                "a1198610",
                "a1346016",
                "a1341430",
                "a1341448",
                "a1198254",
                "a1299301",
                "a1198300",
                "a1343971",
                "a1344170",
                "a1380834",
                "a1341499",
                "a1373846",
                "a1142895",
                "a1078917",
                "a1070002",
                "a948047",
                "a1345796",
                "a1309137",
                "a1198335",
                "a1258540",
                "a1259024",
                "a1320203",
                "a1299352",
                "a1142925",
                "a1198556",
                "a1299441",
                "a1344200",
                "a1180029",
                "a1158090",
                "a1070681",
                "a1320416",
                "a1112392",
                "a1028340",
                "a947792",
                "a1021877",
                "a1198084",
                "a1190989"};

            result = ldapManager.search("(uid=" + username + ")", null);
            if (result) {
                // obtendo  o componente
                LDAPEntry entry = ldapManager.nextEntry();
                // pegando o dn do usuario para efetuar o login
                String loginDN = entry.getDN();
                //if (ldapManager.login(loginDN, password)) {
                // fecha a conexao com o ldap
                for (String string : alunos) {
                    if(ldapManager.search(string)!= null){
                    System.out.println(ldapManager.search(string).getNome());
                    }else{
                        System.out.println(string);
                        //throw new UnknownAccountException("NÃ£o existe conta com este login.");
                    }
                }
                        
                //br.edu.utfpr.cm.saa.entidades.Usuario o = ldapManager.search("a1028367");
                //System.out.println(o.getEmail());
                ldapManager.disconnect();
                // como a autenticacao no ldap jÃ¡ foi realizada a deve ser alterada
                //para permitir a autorizaÃ§Ã£o local
                password = "";
                //} else {
                //throw new UnknownAccountException("NÃ£o existe conta com este login.");
                //}
            }
        } catch (LDAPException ex) {
            Logger.getLogger(MainLDAP.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}