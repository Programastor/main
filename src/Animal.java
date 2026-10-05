class Animal {
    String name;
    int maxRunDistance;
    int maxSwimDistance;
    static int animalCount = 0;

    public Animal(String name, int maxRunDistance, int maxSwimDistance) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxSwimDistance = maxSwimDistance;
        animalCount++;
    }

    public void run(int distance) {
        if (distance <= maxRunDistance && distance > 0) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не может пробежать " + distance + " м. (лимит: " + maxRunDistance + " м.)");
        }
    }

    public void swim(int distance) {
        if (maxSwimDistance == 0) {
            System.out.println(name + " не умеет плавать.");
            return;
        }
        if (distance <= maxSwimDistance && distance > 0) {
            System.out.println(name + " проплыл " + distance + " м.");
        } else {
            System.out.println(name + " не может проплыть " + distance + " м. (лимит: " + maxSwimDistance + " м.)");
        }
    }

    public String getName() {
        return name;
    }

    public static int getAnimalCount() {
        return animalCount;
    }
}
