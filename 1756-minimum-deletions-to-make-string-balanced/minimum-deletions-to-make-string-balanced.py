class Solution:
    def minimumDeletions(self, s: str) -> int:
        bCount = 0
        deletions = 0
        
        for char in s:
            if char == 'b':
                bCount += 1
            else:  # char == 'a'
                deletions = min(deletions + 1, bCount)
        
        return deletions