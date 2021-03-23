import java.util.*;

public class TimeToCollect {
    String[] t1, t2, t3;

    static String getRandomString(int len) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            sb .append(alphabet.charAt((int)(alphabet.length() * Math.random())));
        }
        return sb.toString();
    }

    public TimeToCollect(int n, int m) {
        Random r = new Random();

        this.t1 = new String[n];
        for (int i = 0; i < n; i++) {
            int s = r.nextInt(16)+5;
            t1[i] = getRandomString(s);
        }

        this.t2 = new String[m];
        for (int i = 0; i < m; i++) {
            int s = r.nextInt(m);
            t2[i] = t1[s];
        }

        this.t3 = new String[m];
        for (int i = 0; i < m; i++) {
            int s = r.nextInt(16)+5;
            boolean ok = true;
            do {
                t3[i] = getRandomString(s);
                for (int k = 0; k < n; k++) {
                    if (t3[i].equals(t1[k])) {
                        ok = false;
                        break;
                    }
                }
            } while (!ok);
        }
    }

    public String[] getTab1() {
        return this.t1;
    }

    public String[] getTab2() {
        return this.t2;
    }

    public String[] getTab3() {
        return this.t3;
    }


    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        TimeToCollect myColl = new TimeToCollect(n, m);
        String[] t1 = myColl.getTab1();
        String[] t2 = myColl.getTab2();
        String[] t3 = myColl.getTab3();

        System.out.println("Losowanie dla " + n + " lancuchow.");
        System.out.println("Testowanie dla " + m + " lancuchow.\n");

        List<String> al = new ArrayList<>();
        List<String> ll = new LinkedList<>();
        Map<String, Integer> tm = new TreeMap<>();
        Map<String, Integer> hm = new HashMap<>();

        long startAL, startLL, startTM, startHM, stopAL, stopLL, stopTM, stopHM;
        long timeAL, timeLL, timeTM, timeHM;

        //filling with all t1 elements
        startAL = System.nanoTime();
        for (int i = 0; i < n; i++) {
            al.add(t1[i]);
        }
        stopAL = System.nanoTime();
        timeAL = (stopAL - startAL);

        startLL = System.nanoTime();
        for (int i = 0; i < n; i++) {
            ll.add(t1[i]);
        }
        stopLL = System.nanoTime();
        timeLL = (stopLL - startLL);

        startTM = System.nanoTime();
        for (int i = 0; i < n; i++) {
            tm.put(t1[i], i);
        }
        stopTM = System.nanoTime();
        timeTM = (stopTM - startTM);

        startHM = System.nanoTime();
        for (int i = 0; i < n; i++) {
            hm.put(t1[i], i);
        }
        stopHM = System.nanoTime();
        timeHM = (stopHM - startHM);

        System.out.println("Generate:   ArrayList(" + timeAL + "ns), LinkedList(" + timeLL + "ns), TreeMap(" + timeTM + "ns), HashMap(" + timeHM + "ns)\n");
        System.out.println("Poczatek, rozmiary: " + al.size() + ", " + ll.size() + ", " + tm.size() + ", " + hm.size() + "\n");

        //searching for all elements of array t2
        startAL = System.nanoTime();
        for (int i = 0; i < m; i++) {
            if (al.contains(t2[i]))
                al.get(i);
        }
        stopAL = System.nanoTime();
        timeAL = (stopAL - startAL);

        startLL = System.nanoTime();
        for (int i = 0; i < m; i++) {
            if (ll.contains(t2[i]))
                ll.get(i);
        }
        stopLL = System.nanoTime();
        timeLL = (stopLL - startLL);

        startTM = System.nanoTime();
        for (int i = 0; i < m; i++) {
            if (tm.containsKey(t2[i])) {
                tm.get(t2[i]);
            }
        }
        stopTM = System.nanoTime();
        timeTM = (stopTM - startTM);

        startHM = System.nanoTime();
        for (int i = 0; i < m; i++) {
            if (hm.containsKey(t2[i]))
                hm.get(t2[i]);
        }
        stopHM = System.nanoTime();
        timeHM = (stopHM - startHM);

        System.out.println("Search T2:   ArrayList(" + timeAL + "ns), LinkedList(" + timeLL + "ns), TreeMap(" + timeTM + "ns), HashMap(" + timeHM + "ns)\n");

        //searching for all elements of array t3
        startAL = System.nanoTime();
        for (int i = 0; i < m; i++) {
            if(al.contains(t3[i]))
                al.get(i);
        }
        stopAL = System.nanoTime();
        timeAL = (stopAL - startAL);

        startAL = System.nanoTime();
        for (String s : t3) {
            if (al.contains(s))
                al.get(al.indexOf(s));
        }
        stopAL = System.nanoTime();
        long timeAL1 = (stopAL - startAL);

        startAL = System.nanoTime();
        for (Iterator i = al.iterator(); i.hasNext();) {
           if (al.contains(i.next()))
               al.get(al.indexOf(i.next()));
        }
        stopAL = System.nanoTime();
        long timeAL2 = (stopAL - startAL);


        startLL = System.nanoTime();
        for (int i = 0; i < m; i++) {
            if (ll.contains(t3[i]))
                ll.get(i);
        }
        stopLL = System.nanoTime();
        timeLL = (stopLL - startLL);

        startLL = System.nanoTime();
        for (String s : t3) {
            if (ll.contains(s))
                ll.get(al.indexOf(s));
        }
        stopLL = System.nanoTime();
        long timeLL1 = (stopLL - startLL);

        startLL = System.nanoTime();
        for (Iterator i = al.iterator(); i.hasNext();) {
            if (ll.contains(i.next()))
                ll.get(ll.indexOf(i.next()));
        }
        stopLL = System.nanoTime();
        long timeLL2 = (stopLL - startLL);


        startTM = System.nanoTime();
        for (int i = 0; i < m; i++) {
            if (tm.containsKey(t3[i]))
                tm.get(t3[i]);
        }
        stopTM = System.nanoTime();
        timeTM = (stopTM - startTM);

        startHM = System.nanoTime();
        for (int i = 0; i < m; i++) {
            if (hm.containsKey(t3[i]))
                hm.get(t3[i]);
        }
        stopHM = System.nanoTime();
        timeHM = (stopHM - startHM);

        System.out.println("Search T3:   ArrayList(for -> " + timeAL + "ns, for-each -> " + timeAL1 + "ns, iterator -> " + timeAL2 + "ns), LinkedList(for -> " + timeLL + "ns, for-each -> " + timeLL1 + "ns, iterator -> " + timeLL2 + "ns), TreeMap(" + timeTM + "ns), HashMap(" + timeHM + "ns)\n");

        //going through all elements
        startAL = System.nanoTime();
        for (int i = 0; i < m; i++) {
            al.get(i);
        }
        stopAL = System.nanoTime();
        timeAL = (stopAL - startAL);

        startAL = System.nanoTime();
        for (String s : t3) {
            String a = s;
        }
        stopAL = System.nanoTime();
        timeAL1 = (stopAL - startAL);

        startAL = System.nanoTime();
        for (Iterator i = al.iterator(); i.hasNext();) {
            al.get(al.indexOf(i.next()));
        }
        stopAL = System.nanoTime();
        timeAL2 = (stopAL - startAL);


        startLL = System.nanoTime();
        for (int i = 0; i < m; i++) {
            ll.get(i);
        }
        stopLL = System.nanoTime();
        timeLL = (stopLL - startLL);

        startLL = System.nanoTime();
        for (String s : t3) {
            String a = s;
        }
        stopLL = System.nanoTime();
        timeLL1 = (stopLL - startLL);

        startLL = System.nanoTime();
        for (Iterator i = al.iterator(); i.hasNext();) {
            ll.get(ll.indexOf(i.next()));
        }
        stopLL = System.nanoTime();
        timeLL2 = (stopLL - startLL);

        System.out.println("Iterating through all elements:   ArrayList(for -> " + timeAL + "ns, for-each -> " + timeAL1 + "ns, iterator -> " + timeAL2 + "ns), LinkedList(for -> " + timeLL + "ns, for-each -> " + timeLL1 + "ns, iterator -> " + timeLL2 + "ns)\n");


        //removing all elements at once
        startAL = System.nanoTime();
        al.clear();
        stopAL = System.nanoTime();
        timeAL = (stopAL - startAL);

        startLL = System.nanoTime();
        ll.clear();
        stopLL = System.nanoTime();
        timeLL = (stopLL - startLL);

        startTM = System.nanoTime();
        tm.clear();
        stopTM = System.nanoTime();
        timeTM = (stopTM - startTM);

        startHM = System.nanoTime();
        hm.clear();
        stopHM = System.nanoTime();
        timeHM = (stopHM - startHM);

        System.out.println("Remove:   ArrayList(" + timeAL + "ns), LinkedList(" + timeLL + "ns), TreeMap(" + timeTM + "ns), HashMap(" + timeHM + "ns)\n");
        System.out.println("Koniec, rozmiary: " + al.size() + ", " + ll.size() + ", " + tm.size() + ", " + hm.size() + "\n");
    }
}
