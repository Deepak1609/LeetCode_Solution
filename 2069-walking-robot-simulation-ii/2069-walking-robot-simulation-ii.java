class Robot {

    int x, y;
    int width, height;
    int dir; // 0=East, 1=North, 2=West, 3=South
    int perimeter;

    public Robot(int width, int height) {
        this.width = width;
        this.height = height;
        this.x = 0;
        this.y = 0;
        this.dir = 0; // East
        this.perimeter = 2 * (width - 1) + 2 * (height - 1);
    }

    public void step(int num) {
        if (perimeter == 0) return;

        num %= perimeter;
        if (num == 0) num = perimeter;

        while (num > 0) {

            if (dir == 0) { // East
                int steps = Math.min(num, width - 1 - x);
                x += steps;
                num -= steps;
                if (steps == 0) dir = 1;
            }

            else if (dir == 1) { // North
                int steps = Math.min(num, height - 1 - y);
                y += steps;
                num -= steps;
                if (steps == 0) dir = 2;
            }

            else if (dir == 2) { // West
                int steps = Math.min(num, x);
                x -= steps;
                num -= steps;
                if (steps == 0) dir = 3;
            }

            else { // South
                int steps = Math.min(num, y);
                y -= steps;
                num -= steps;
                if (steps == 0) dir = 0;
            }
        }
    }

    public int[] getPos() {
        return new int[]{x, y};
    }

    public String getDir() {
        String[] dirs = {"East", "North", "West", "South"};
        return dirs[dir];
    }
}