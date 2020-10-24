package org.roostify.endpoint.admin;

/**
 * Responsible for mapping quiz requests.
 * TODO Could have applied jsonignore... but for now keeping it simple
 */
public class QuizRequest {


     int sets;
     int nQuestions;
     int nOptions;

     public int getSets() {
          return sets;
     }

     public void setSets(int sets) {
          this.sets = sets;
     }

     public int getnQuestions() {
          return nQuestions;
     }

     public void setnQuestions(int nQuestions) {
          this.nQuestions = nQuestions;
     }

     public int getnOptions() {
          return nOptions;
     }

     public void setnOptions(int nOptions) {
          this.nOptions = nOptions;
     }

     @Override
     public String toString() {
          return "QuizRequest{" +
                  "sets=" + sets +
                  ", nQuestions=" + nQuestions +
                  ", nOptions=" + nOptions +
                  '}';
     }
}
