package io;

import com.opencsv.CSVParser;
import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ItemCSVReader implements ItemReader {
    private String filePath;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss.S");

    public ItemCSVReader(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<OriginItem> read() {
        List<OriginItem> result = new ArrayList<>();
        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader(filePath), 1, new CSVParser());
            String[] line;
            while ((line = reader.readNext()) != null) {
                int id = Integer.parseInt(line[1]);
                String title = line[2];
                String content = line[3];
                Integer sellType = parseInteger(line[4]);
                Float minPrice = parseFloat(line[5]);
                Float maxPrice = parseFloat(line[6]);
                Float minArea = parseFloat(line[7]);
                Float maxArea = parseFloat(line[8]);
                Integer cateId = parseInteger(line[9]);
                Integer cityId = parseInteger(line[10]);
                Integer districtId = parseInteger(line[11]);
                Integer numBedRoom = parseInteger(line[12]);
                Integer viewCount = parseInteger(line[13]);
                Integer callCount = parseInteger(line[14]);
                Date startDate = null;
                try {
                    startDate = simpleDateFormat.parse(line[15]);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                Date endDate = null;
                try {
                    endDate = simpleDateFormat.parse(line[15]);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                OriginItem item = new OriginItem(id, title, content, sellType, minPrice, maxPrice, minArea, maxArea,
                        cateId, cityId, districtId, numBedRoom, viewCount, callCount, startDate, endDate);
                result.add(item);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (reader != null) {
                reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private Integer parseInteger(String text) {
        if (text.equalsIgnoreCase("null")) {
            return null;
        } else {
            return Integer.parseInt(text);
        }
    }

    private Float parseFloat(String text) {
        if (text.equalsIgnoreCase("null")) {
            return null;
        } else {
            return Float.parseFloat(text);
        }
    }

//    public static void main(String[] args) throws ParseException {
//        ItemCSVReader itemCSVReader = new ItemCSVReader("Data/Top1000NewProduct.csv");
//        itemCSVReader.read();
//
////        String s = "2018-07-12 10:42:17.000";
////        System.out.println(itemCSVReader.simpleDateFormat.format(new Date()));
////        System.out.println(itemCSVReader.simpleDateFormat.parse(s));
////        itemCSVReader.
//    }
}
