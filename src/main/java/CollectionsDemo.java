import java.util.*;

public class CollectionsDemo {

    //Вход: список строк и символ. Выход: количество строк входного списка, у которых первый
    //символ совпадает с заданным.
    public  static int NumberOfLinesWithCharacter(List<String> stringList, char symbol){
        int count = 0;

        if(stringList == null) {
            return count;
        }

        for(String l: stringList){
            char ch = l.charAt(0);
            if(ch == symbol){
                count++;
            }
        }
        return count;
    }

    //Напишите метода класса ListDemo, который получает на вход список объектов типа Human
    //и еще один объект типа Human. Результат — список однофамильцев заданного человека
    //среди людей из входного списка.

    public static List<Human> listOfNamesakes (List<Human> peopleList, Human human){
        List<Human> listNamesakes = new ArrayList<>(peopleList.size());
        if (human == null){
            return  listNamesakes;
        }
        for (Human h: peopleList){
            if(h != null && h.getSurname().equals(human.getSurname())){
                listNamesakes.add(h);
            }
        }
        return  listNamesakes;
    }

    //Вход: список объектов типа Human и еще один объект типа Human. Выход — копия
    //входного списка, не содержащая выделенного человека. При изменении элементов
    //входного списка элементы выходного изменяться не должны.

    public static List<Human> copyOfListWithoutPerson (List<Human> peopleList, Human person){
        List<Human> newPeopleList = new ArrayList<>(peopleList.size());
        for (Human h: peopleList){
            if (!h.equals(person)){
                newPeopleList.add(h);
            }
        }
        return  newPeopleList;
    }


    //Вход: список множеств целых чисел и еще одно множество. Выход: список всех множеств
    //входного списка, которые не пересекаются с заданным множеством.
    public  static List<Set<Integer>> listOfSetsWithoutIntersection (List<Set<Integer>> listOfSetsInt,
                                                                     Set<Integer> set){
        List<Set<Integer>> newList = new ArrayList<>(listOfSetsInt.size());
        Set<Integer> integerSet = new HashSet<>();
        for (Set<Integer> s: listOfSetsInt){
            integerSet.addAll(s);
            if (integerSet.retainAll(set)){
                newList.add(s);
            }
            integerSet.clear();
        }

        return newList;
    }


    // Напишите метод класса ListDemo, который получает на вход список, состоящий из объектов типа Human
    // и его производных классов.
    // Результат — множество людей из входного списка с максимальным возрастом.
    public static <T extends Human> Set<T> peopleWithMaxAge(List<T> people){
        Set<T> setPeopleWithMaxAge = new HashSet<>();
        int maxAge = 0;
        for (T p: people){
            if(p.getAge() > maxAge){
                maxAge = p.getAge();
            }
        }
        for (T p2: people){
            if (p2.getAge() == maxAge){
                setPeopleWithMaxAge.add(p2);
            }
        }
        return setPeopleWithMaxAge;
    }

    //Имеется набор людей, каждому человеку задан уникальный целочисленный
    //идентификатор. Напишите метод, который получает на вход отображение (Map)
    //целочисленных идентификаторов в объекты типа Human и множество целых чисел.
    //Результат — множество людей, идентификаторы которых содержатся во входном
    //множестве.
    public static Set<Human> peopleWithAGivenID(Map<Integer, Human> integerHumanMap, Set<Integer> integerSet){
        Set<Human> humans = new HashSet<>(integerHumanMap.size());
        Set<Integer> keySet = integerHumanMap.keySet();
        keySet.retainAll(integerSet);

        for(int key: keySet){
            humans.add(integerHumanMap.get(key));
        }

        return humans;
    }


    //Для отображения из задачи 7 постройте список идентификаторов людей, чей возраст не
    //менее 18 лет.
    public static List<Integer> adultIdentifiers(Map<Integer, Human> integerHumanMap){
        int age = 18;
        List<Integer> listID = new ArrayList<>();
        for (Map.Entry<Integer, Human> entry: integerHumanMap.entrySet()){
            if(entry.getValue().getAge() >= age){
                listID.add(entry.getKey());
            }
        }
        return listID;
    }


    //Для отображения из задачи 7 постройте новое отображение, которое идентификатору
    //сопоставляет возраст человека.
    public static Map<Integer, Integer> matchingIDToAge(Map<Integer, Human> integerHumanMap){
        Map<Integer, Integer> integerAgeMap = new HashMap<>(integerHumanMap.size());
        for (Map.Entry<Integer, Human> entry: integerHumanMap.entrySet()){
            integerAgeMap.put(entry.getKey(), entry.getValue().getAge());
        }
        return integerAgeMap;
    }

    //По множеству объектов типа Human постройте отображение, которое целому числу
    //(возраст человека) сопоставляет список всех людей данного возраста из входного
    //множества.
    public static Map<Integer, List<Human>> listOfPeopleOfThisAge(Set<Human> humans){
        Map<Integer, List<Human>> integerListMap = new HashMap<>(humans.size());
        List<Human> humanList = new ArrayList<>();
        Set<Integer> age = new HashSet<>();

        for(Human human: humans){
            age.add(human.getAge());
        }

        for (int a: age){
            for (Human human: humans){
                if(human.getAge() == a){
                    humanList.add(human);
                }
            }
            integerListMap.put(a, new ArrayList<>(humanList));
            humanList.clear();
        }
        return integerListMap;
    }


}
