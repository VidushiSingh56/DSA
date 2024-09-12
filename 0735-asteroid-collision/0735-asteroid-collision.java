class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            boolean exploded = false;

            // While the stack is not empty and there's a potential collision
            while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {
                // Compare sizes
                if (Math.abs(stack.peek()) < Math.abs(asteroid)) 
                {
                    stack.pop(); // Current asteroid in stack gets destroyed
                } 
                else if (Math.abs(stack.peek()) == Math.abs(asteroid)) 
                {
                    stack.pop(); // Both asteroids get destroyed
                    exploded = true; // Mark the asteroid as exploded
                    break;
                } 
                else 
                {
                    exploded = true; // Current asteroid is destroyed
                    break;
                }
            }

            if (!exploded) {
                stack.push(asteroid); // Push the asteroid to the stack if it survived
            }
        }

        // Convert stack to array for the result
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}
