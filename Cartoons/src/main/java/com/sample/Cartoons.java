package com.sample;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class Cartoons {
    
    public static GuiHandler guiHandler = new GuiHandler();

    public static void main(String[] args) {
        try {
            KieServices ks = KieServices.Factory.get();
            KieContainer kContainer = ks.getKieClasspathContainer();
            KieSession kSession = kContainer.newKieSession("ksession-rules");

            kSession.setGlobal("guiHandler", guiHandler);

            kSession.fireAllRules();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    // Classes Answer and Question stay as they are
    public static class Answer {
        public String myAnswer;
        public int ans;

        public Answer(String answer) {
            this.myAnswer = answer;
        }

        public String getAnswer() {
            return this.myAnswer;
        }
    }

    public static class Question {
        public String qstext;
        public String anstext;

        public Question(String quest, Object ans) { 
            this.qstext = quest;
            this.anstext = (String) ans;
        }

        public String getQuestion() {
            return this.qstext;
        }
    }
}
