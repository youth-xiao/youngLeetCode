class Solution:
    def addStrings(self, num1: str, num2: str) -> str:
        len1 = len(num1) - 1
        len2 = len(num2) - 1
        
        carry = 0
        result = []
        
        while len1 >= 0 or len2 >= 0:            
            digit1 = 0
            if (len1 >= 0):
                digit1 = ord(num1[len1]) - ord('0')
        
            digit2 = 0
            if (len2 >= 0):
                digit2 = ord(num2[len2]) - ord('0')
                
            total = digit1 + digit2 + carry
            val = total % 10
            carry = total // 10
            result.append(val)
            len1 -= 1
            len2 -= 1
            
        if carry:
            result.append(carry)
            
        return ''.join(str(x) for x in result[::-1])