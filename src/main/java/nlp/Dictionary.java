package nlp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * Represent dictionary, provide method process with Dictionary as:  get represent vector
 */
public class Dictionary {
    private Map<String, Integer> token2id;
    private Map<Integer, String> id2token;
    private Map<Integer, Integer> dfs;
    private Integer numDocs;

    public Dictionary() {
        token2id = new HashMap<>();
        dfs = new HashMap<>();
        numDocs = 0;
        id2token = null;
    }

    /**
     * Update Dictionary with multi document. Each document is a List of tokens
     *
     * @param docs list documents
     */
    public void addDocs(List<List<String>> docs) {
        for (List<String> doc : docs) {
            addDoc(doc);
        }
    }

    /**
     * Update Dictionary with one document.
     *
     * @param doc list tokens of document
     */
    public void addDoc(List<String> doc) {
        for (String token : new HashSet<String>(doc)) {
            Integer id = token2id.get(token);
            if (id == null) {
                id = token2id.size();
                token2id.put(token, id);
                if (id2token != null) {
                    id2token.put(id, token);
                }
                dfs.put(id, 1);
            } else {
                dfs.put(id, dfs.get(id) + 1);
            }
        }
        numDocs++;
    }

    /**
     * Get tf-idf vector of a document
     *
     * @param doc document need to get tf-idf vector
     * @return a Map represent tf-idf vector of document
     */
    public Map<Integer, Double> docToTfidf(List<String> doc) {
        Map<Integer, Integer> bow = docToBow(doc);
        Map<Integer, Double> tf_idf = new HashMap<>();
        for (Map.Entry<Integer, Integer> bowEntry : bow.entrySet()) {
            int id = bowEntry.getKey();
            tf_idf.put(id, (1 + Math.log(bowEntry.getValue())) * Math.log((float) numDocs / dfs.get(id)));
        }
        return tf_idf;
    }

    /**
     * Get tf-idf vector with L2 normalized of a document
     *
     * @param doc document need to get tf-idf vector
     * @return a Map represent tf-idf vector of document
     */
    public Map<Integer, Double> docToTfidfNormalized(List<String> doc) {
        Map<Integer, Integer> bow = docToBow(doc);
        Map<Integer, Double> tf_idf = new HashMap<>();
        double sumSquare = 0f;
        for (Map.Entry<Integer, Integer> bowEntry : bow.entrySet()) {
            int id = bowEntry.getKey();
            double tfIdfValue = (1 + Math.log(bowEntry.getValue())) * Math.log((float) numDocs / dfs.get(id));
            tf_idf.put(id, (1 + tfIdfValue));
            sumSquare += tfIdfValue * tfIdfValue;
        }
        double rootSumSquare = Math.sqrt(sumSquare);
        for (Map.Entry<Integer, Double> tfIdfEntry : tf_idf.entrySet()) {
            tf_idf.put(tfIdfEntry.getKey(), tfIdfEntry.getValue() / rootSumSquare);
        }
        return tf_idf;
    }

    /**
     * Get bag of word of a document
     *
     * @param doc in put document
     * @return A Map represent bow vector
     */
    public Map<Integer, Integer> docToBow(List<String> doc) {
        Map<Integer, Integer> bow = new HashMap<Integer, Integer>();
        for (String token : doc) {
            Integer id = token2id.get(token);
            if (id != null) {
                Integer count = bow.getOrDefault(id, 0);
                bow.put(id, count + 1);
            }
        }
        return bow;
    }

    /**
     * get token by token id
     *
     * @param id input token id
     * @return token string if token be contained in Dictionary, otherwise return null;
     */
    public String getToken(int id) {
        if (id2token == null) {
            id2token = new HashMap<>();
            for (Map.Entry<String, Integer> token2idEntry : token2id.entrySet()) {
                id2token.put(token2idEntry.getValue(), token2idEntry.getKey());
            }
        }
        return id2token.get(id);
    }
}
