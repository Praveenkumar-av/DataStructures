
def expected_swims(N, M, X, Y):
    E = [[0.0] * M for _ in range(N + 1)]

    for i in range(N - 1, -1, -1):
        for j in range(M):
            expected_value = 0.0
            count = 0
            
            if j > 0:
                expected_value += E[i][j - 1]
                count += 1
            
            if j < M - 1:
                expected_value += E[i][j + 1]
                count += 1
            
            expected_value += E[i + 1][j]
            count += 1
            
            expected_value += E[i][j]
            count += 1
            
            E[i][j] = 1 + expected_value / count

    return E[X][Y]

N = 5  # depth
M = 5  # width
X = 2  # current depth
Y = 2  # current width
result = expected_swims(N, M, X, Y)
print(f"Expected number of swims: {result:.6f}") 

'''
def find_expected_swims(X, Y, N, M):
    # Base case: if we are at the bottom (depth N), no more swims are needed
    if X == N:
        return 0

    expected_sum = 0

    # Move down
    expected_sum += find_expected_swims(X + 1, Y, N, M)
    
    # Move left
    if Y > 0:
        expected_sum += find_expected_swims(X, Y - 1, N, M)
    else:
        expected_sum += find_expected_swims(X, Y, N, M)  # Stay if at left edge

    # Move right
    if Y < M - 1:
        expected_sum += find_expected_swims(X, Y + 1, N, M)
    else:
        expected_sum += find_expected_swims(X, Y, N, M)  # Stay if at right edge

    # Stay in the same place
    expected_sum += find_expected_swims(X, Y, N, M)

    return (4.0 / 3.0) * (1 + expected_sum / 4.0)


N = 5  # depth
M = 5  # width
X = 2  # current depth
Y = 2  # current width

result = find_expected_swims(X, Y, N, M)
print(f"{result:.6f}")
'''

'''
MOD = 10**9 + 7
def is_valid(grid, N):
    directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]  
    for i in range(N):
        for j in range(N):
            if grid[i][j] == 'G':  # Grizzly bear check
                for di, dj in directions:
                    ni, nj = i + di, j + dj
                    if 0 <= ni < N and 0 <= nj < N and grid[ni][nj] != '.':
                        return False
            elif grid[i][j] == 'B':  # Brown bear check
                for di, dj in directions:
                    ni, nj = i + di, j + dj
                    if 0 <= ni < N and 0 <= nj < N and grid[ni][nj] not in ('.', 'B'):
                        return False
            elif grid[i][j] == 'P':  # Polar bear check
                for di, dj in directions:
                    ni, nj = i + di, j + dj
                    if 0 <= ni < N and 0 <= nj < N and grid[ni][nj] not in ('.', 'P'):
                        return False
    return True

def solve_bearland(grid, N):
    question_cells = []
    
    # Find the positions of the '?' cells
    for i in range(N):
        for j in range(N):
            if grid[i][j] == '?':
                question_cells.append((i, j))
    
    X = len(question_cells)
    total_ways = 0
    
    # Try all 3^X configurations of replacing '?' with 'B', 'G', 'P'
    from itertools import product
    for config in product('BGP', repeat=X):
        # Create a copy of the grid
        new_grid = [list(row) for row in grid]
        
        # Apply the current configuration
        for idx, (i, j) in enumerate(question_cells):
            new_grid[i][j] = config[idx]
        
        # Check if this configuration is valid
        if is_valid(new_grid, N):
            total_ways += 1
            total_ways %= MOD
    
    return total_ways

# Example usage:
N = 3
grid = [
    "B.G",
    ".?.",
    "P.B"
]
print('No of ways :',solve_bearland(grid, N))

MOD = 10**9 + 7

def is_valid_cell(grid, N, i, j):
    directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]  
    if grid[i][j] == 'G':  # Grizzly bear check
        for di, dj in directions:
            ni, nj = i + di, j + dj
            if 0 <= ni < N and 0 <= nj < N and grid[ni][nj] != '.':
                return False
    elif grid[i][j] == 'B':  # Brown bear check
        for di, dj in directions:
            ni, nj = i + di, j + dj
            if 0 <= ni < N and 0 <= nj < N and grid[ni][nj] not in ('.', 'B'):
                return False
    elif grid[i][j] == 'P':  # Polar bear check
        for di, dj in directions:
            ni, nj = i + di, j + dj
            if 0 <= ni < N and 0 <= nj < N and grid[ni][nj] not in ('.', 'P'):
                return False
    return True

def is_valid_grid(grid, N):
    for i in range(N):
        for j in range(N):
            if grid[i][j] != '?' and not is_valid_cell(grid, N, i, j):
                return False
    return True

def solve_bearland(grid, N):
    question_cells = []
    
    # Find the positions of the '?' cells
    for i in range(N):
        for j in range(N):
            if grid[i][j] == '?':
                question_cells.append((i, j))
    
    # Precompute if the fixed grid is already invalid
    if not is_valid_grid(grid, N):
        return 0
    
    total_ways = [0]  # Use list to modify inside recursive function
    
    def backtrack(idx):
        if idx == len(question_cells):
            total_ways[0] += 1
            total_ways[0] %= MOD
            return
        
        i, j = question_cells[idx]
        
        for char in 'BGP':
            grid[i][j] = char
            if is_valid_cell(grid, N, i, j):
                backtrack(idx + 1)
            # No need to undo grid[i][j] because it will be 
            # overwritten in the next iteration.
        
        grid[i][j] = '?'  # Reset the cell after all attempts
    
    # Start backtracking from the first '?' cell
    backtrack(0)
    
    return total_ways[0]

N = 3
grid = [
    "B.G",
    ".?.",
    "P.B"
]
print('No of ways :', solve_bearland(grid, N)) '''
