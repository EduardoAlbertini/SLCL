/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.XML;

import br.com.entitys.Livro;
import java.util.Iterator;
import java.util.List;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author Miray
 */
public class XMLReader {

    private String localXML = "http://isbndb.com/api/books.xml?access_key=BZSBMWHJ&index1=isbn&value1=";

    public XMLReader() {
    }

    public Livro getLivro(String ISBN) throws Exception {
        SAXBuilder buider = new SAXBuilder();
        String xml = localXML + ISBN;
        Document dom = buider.build(xml);

        Element root = dom.getRootElement();
        Element elem = root.getChild("BookList");

        List<Element> books = elem.getChildren();
        Iterator<Element> itr = books.iterator();
        Livro livro = null;

        while (itr.hasNext()) {
            Element book = itr.next();

            String ISBN10 = book.getAttributeValue("isbn");
            String ISBN13 = book.getAttributeValue("isbn13");
            String titulo = book.getChildText("Title");
            String tituloCompleto = book.getChildText("TitleLong");
            String autores = book.getChildText("AuthorsText");
            String editora = book.getChildText("PublisherText");

            livro = new Livro(tituloCompleto, titulo, autores, null, editora, ISBN10, ISBN13, null, null, null);

        }
        return livro;


    }
}
