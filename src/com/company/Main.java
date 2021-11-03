package com.company;

public class Main {

    public enum Direction {
        UP,
        RIGHT,
        DOWN,
        LEFT
    }

    public static class Robot {
        int x;
        int y;
        Direction dir;

        public Robot(int x, int y, Direction dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }

        public Direction getDirection() {
            return dir;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void turnLeft() {
            if (dir == Direction.UP) {
                dir = Direction.LEFT;
            } else if (dir == Direction.DOWN) {
                dir = Direction.RIGHT;
            } else if (dir == Direction.LEFT) {
                dir = Direction.DOWN;
            } else if (dir == Direction.RIGHT) {
                dir = Direction.UP;
            }
        }

        public void turnRight() {
            if (dir == Direction.UP) {
                dir = Direction.RIGHT;
            } else if (dir == Direction.DOWN) {
                dir = Direction.LEFT;
            } else if (dir == Direction.LEFT) {
                dir = Direction.UP;
            } else if (dir == Direction.RIGHT) {
                dir = Direction.DOWN;
            }
        }

        public void stepForward() {
            if (dir == Direction.UP) {
                y++;
            }
            if (dir == Direction.DOWN) {
                y--;
            }
            if (dir == Direction.LEFT) {
                x--;
            }
            if (dir == Direction.RIGHT) {
                x++;
            }
        }
    }

    private static void setDirection(Robot robot, Direction direction) {
        if (direction.ordinal() - robot.getDirection().ordinal() < 0) {
            while (robot.getDirection() != direction) {
                robot.turnLeft();

                // тестовая печать
                System.out.println("Поворачиваем влево");
            }

        }
        else {
            while (robot.getDirection() != direction) {
                robot.turnRight();

                // тестовая печать
                System.out.println("Поворачиваем вправо");
            }

        }
    }

    public static void moveRobot(Robot robot, int toX, int toY) {

        // test print
        System.out.println("X begin = " + robot.getX() + ", Y begin = " + robot.getY());
        System.out.println("X to go = " + toX + ", Y to go = " + toY + "\n");

        // move to X
        if (robot.getX() > toX) {
            setDirection (robot, Direction.LEFT);
            while (robot.getX() != toX) {
                robot.stepForward();
            }
        } else {
            if (robot.getX() < toX) {
                setDirection (robot, Direction.RIGHT);
                while (robot.getX() != toX) {
                    robot.stepForward();
                }
            }
        }

        // move to Y
        if (robot.getY() > toY) {
            setDirection (robot, Direction.DOWN);
            while (robot.getY() != toY) {
                robot.stepForward();
            }
        } else {
            if (robot.getY() < toY) {
                setDirection (robot, Direction.UP);
                while (robot.getY() != toY) {
                    robot.stepForward();
                }
            }
        }

        // test print
        System.out.println("X final = " + robot.getX() + ", Y final = " + robot.getY());
    }

    public static void main(String[] args) {
        Robot robot = new Robot(3, 3, Direction.LEFT);
        moveRobot(robot, 5, 5);
    }
}