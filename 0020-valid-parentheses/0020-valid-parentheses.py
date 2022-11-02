class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        for ch in s:
            if ch is '(':
                stack.append(')')
            elif ch is '[':
                stack.append(']')
            elif ch is '{':
                stack.append('}')
            elif not stack or stack.pop() is not ch:
                return False
        return not stack
                