package nlp;

import io.ItemCSVReader;
import io.OriginItem;

import java.util.List;

public class test {
    public static void main(String[] args) {

        ItemCSVReader itemCSVReader = new ItemCSVReader("Data/Top1000NewProduct.csv");
        List<OriginItem> itemList = itemCSVReader.read();
        for(OriginItem item: itemList){
            System.out.println(HtmlPreprocess.removeHtmlTags(item.getContent()));
        }
    }
}
