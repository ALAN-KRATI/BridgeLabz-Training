import java.util.*;

class Version {
    String name;
    int size;

    Version(String name, int size) {
        this.name = name;
        this.size = size;
    }
}

public class VersionStorage {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        Map<String, List<Version>> files = new HashMap<>();

        for(int i = 0; i < n; i++) {

            String line = sc.nextLine();
            String[] parts = line.split(" ");

            String operation = parts[0];

            if(operation.equals("UPLOAD")) {

                String file = parts[1];
                String version = parts[2];
                int size = Integer.parseInt(parts[3]);

                files.putIfAbsent(file, new ArrayList<>());

                boolean exists = false;

                for(Version v : files.get(file)) {
                    if(v.name.equals(version)) {
                        exists = true;
                        break;
                    }
                }

                if(!exists) {
                    files.get(file).add(new Version(version, size));
                }
            }

            else if(operation.equals("FETCH")) {

                String file = parts[1];

                if(!files.containsKey(file)) {
                    System.out.println("File Not Found");
                    continue;
                }

                List<Version> list = new ArrayList<>(files.get(file));

                list.sort((a,b)->{
                    if(a.size != b.size)
                        return a.size - b.size;
                    return a.name.compareTo(b.name);
                });

                for(Version v : list) {
                    System.out.println(file + " " + v.name + " " + v.size);
                }
            }

            else if(operation.equals("LATEST")) {

                String file = parts[1];

                if(!files.containsKey(file) || files.get(file).isEmpty()) {
                    System.out.println("File Not Found");
                    continue;
                }

                Version v = files.get(file).get(files.get(file).size()-1);

                System.out.println(file + " " + v.name + " " + v.size);
            }

            else if(operation.equals("TOTAL_STORAGE")) {

                String file = parts[1];

                if(!files.containsKey(file)) {
                    System.out.println("File Not Found");
                    continue;
                }

                int sum = 0;

                for(Version v : files.get(file)) {
                    sum += v.size;
                }

                System.out.println(file + " " + sum);
            }
        }
    }
}