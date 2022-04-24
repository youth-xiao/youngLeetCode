// class Solution {
//     public int[] asteroidCollision(int[] asteroids) {
//         Stack<Integer> stackPos = new Stack<>();
//         Stack<Integer> stackNeg = new Stack<>();
//         int firstAsteroid = asteriods[0];
//         int index = 1;
//         boolean posPointer;
//         if (firstAsteroid > 0) {
//             stackPos.push(firstAsteroid);
//             posPointer = true;
//         } else {
//             stackNeg.push(firstAsteroid);
//             posPointer = false;
//         }
//         int currTop = firstAsteroid;
        
//         while (index < asteroids.length) {
//             int newAsteroid = asteroids[index];
//             if (currTop * newAsteroid > 0) { // same direction
//                 if (posPositive = true) {
//                     stackPos.push(newAsteroids);
//                 } else {
//                     stackNeg.push(newAsteroids);
//                 }
//                 index++;
//             }
//         }
//     }
// }


class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int ast : asteroids) {
            collision: {
                while (!stack.isEmpty() && ast < 0 && stack.peek() > 0) {
                    if (stack.peek() < -ast) {
                        stack.pop();
                        continue;
                    } else if (stack.peek() == -ast) {
                        stack.pop();
                    }
                    break collision;
                }
                stack.push(ast);
            }
        }
        
        int size = stack.size();
        int[] res = new int[size];
        int k = size - 1;
        while (!stack.isEmpty()) {
            res[k] = stack.pop();
            k--;
        }
        
        return res;
    }
}