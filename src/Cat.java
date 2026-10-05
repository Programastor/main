class Cat extends Animal {
    boolean isFull = false;
    static int catCount = 0;

    public Cat(String name) {
        super(name, 200, 0);
        catCount++;
    }

    public boolean eat(Bowl bowl, int amount) {
        if (bowl.getFood() >= amount) {
            bowl.decreaseFood(amount);
            isFull = true;
            System.out.println(name + " съел " + amount + " еды. Сытость: " + isFull);
            return true;
        } else {
            System.out.println(name + " не хватило еды в миске. Сытость: " + isFull);
            return false;
        }
    }

    public boolean isFull() {
        return isFull;
    }

    public static int getCatCount() {
        return catCount;
    }
}
