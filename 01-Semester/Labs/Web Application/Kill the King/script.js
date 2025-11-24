document.addEventListener('DOMContentLoaded', () => {
    const canvas = document.getElementById('gameCanvas');
    const ctx = canvas.getContext('2d');

    const scoreDisplay = document.getElementById('score');
    const highScoreDisplay = document.getElementById('highScore');
    const livesContainer = document.getElementById('lives');
    const powerUpTimerDisplay = document.getElementById('powerUpTimerDisplay');

    const startScreen = document.getElementById('startScreen');
    const pausedScreen = document.getElementById('pausedScreen');
    const gameOverScreen = document.getElementById('gameOverScreen');
    const finalScoreDisplay = document.getElementById('finalScore');

    const startButton = document.getElementById('startButton');
    const resumeButton = document.getElementById('resumeButton');
    const restartButton = document.getElementById('restartButton');

    // --- Game Constants ---
    const GRID_SIZE = 20; // Pixels per grid cell
    const GRID_WIDTH = canvas.width / GRID_SIZE;
    const GRID_HEIGHT = canvas.height / GRID_SIZE;

    const GAME_SPEED = 150; // Milliseconds per game tick (lower = faster)
    const GHOST_SPEED_NORMAL = 200; // Milliseconds per ghost tick
    const GHOST_SPEED_FRIGHTENED = 300;
    const GHOST_SPEED_EATEN = 100;

    const POWER_UP_DURATION = 8000; // 8 seconds
    const POWER_UP_FLASH_THRESHOLD = 3000; // Start flashing when 3 seconds left
    const GHOST_RESPAWN_DELAY = 4000; // 4 seconds
    const LIVES_START = 3;
    const INITIAL_SNAKE_LENGTH = 3;

    // --- Neo-Brutalism Colors ---
    const COLOR_PRIMARY = '#e32400';
    const COLOR_BACKGROUND = '#e32400'; // Body background
    const COLOR_SURFACE = '#e32400'; // Canvas background / Paths
    const COLOR_TEXT = '#000000';
    const COLOR_MUTED_TEXT = '#ffffff';
    const COLOR_BORDER = '#000000';

    // Game Element Specific Colors
    const WALL_COLOR = COLOR_BORDER;
    const WALL_BORDER_COLOR = COLOR_PRIMARY;
    const SNAKE_COLOR = COLOR_MUTED_TEXT;
    const SNAKE_BORDER_COLOR = COLOR_BORDER;
    const FOOD_COLOR = COLOR_BORDER;
    const FOOD_BORDER_COLOR = COLOR_MUTED_TEXT;
    const POWER_PELLET_COLOR = COLOR_PRIMARY;
    const POWER_PELLET_BORDER_COLOR = COLOR_BORDER;

    const GHOST_BLINKY_COLOR = '#ff0000'; // Red
    const GHOST_PINKY_COLOR = '#ffc0cb'; // Pink
    const GHOST_INKY_COLOR = '#00ffff'; // Cyan
    const GHOST_CLYDE_COLOR = '#ffa500'; // Orange
    const GHOST_FRIGHTENED_COLOR = '#00008b'; // Dark blue
    const GHOST_EATEN_EYE_COLOR = COLOR_MUTED_TEXT;

    // --- Game State Variables ---
    let gameState = 'START'; // 'START', 'PLAYING', 'PAUSED', 'GAME_OVER'
    let score = 0;
    let highScore = localStorage.getItem('pacSnakeHighScore') || 0;
    let lives = LIVES_START;

    let snake;
    let snakeDirection = { x: 1, y: 0 }; // Initial movement: right
    let nextDirection = { x: 1, y: 0 }; // Queued direction

    let foodPellets = [];
    let powerPellets = [];

    let ghosts = [];
    const GHOST_STATE = {
        NORMAL: 'normal',
        FRIGHTENED: 'frightened',
        EYES_ONLY: 'eyesOnly'
    };

    let powerUpActive = false;
    let powerUpTimer = 0;
    let frightenedGhostFlashTimer = 0;
    let frightenedGhostsEatenThisPowerUp = 0;

    let gameInterval;
    let ghostIntervals = {};
    let lastUpdateTime = 0;

    // --- Maze Definition (30x30) ---
    // 0 = Path, 1 = Wall, 2 = Ghost Den Path (temporarily, will be 0 during gameplay)
    const MAZE_GRID = [
        [1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1],
        [1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1],
        [1,0,1,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,0,1,1,1,0,1],
        [1,0,1,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,0,1,1,1,0,1],
        [1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1],
        [1,0,1,1,1,1,0,1,0,1,1,1,1,1,1,1,1,1,1,1,0,1,0,1,1,1,1,0,1,1],
        [1,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1],
        [1,1,1,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1],
        [1,1,1,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1],
        [1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1],
        [1,0,1,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,0,1,1,1,0,1],
        [1,0,1,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,0,1,1,1,0,1],
        [1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1],
        [1,1,1,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1],
        [1,1,1,1,1,1,0,1,1,0,0,0,0,2,2,2,2,0,0,0,0,1,1,1,0,1,1,1,1,1],
        [1,0,0,0,0,0,0,0,1,0,1,1,1,2,1,1,2,1,1,1,0,1,0,0,0,0,0,0,0,1],
        [1,0,1,1,1,1,0,1,1,0,1,1,1,2,1,1,2,1,1,1,0,1,0,1,1,1,1,0,1,1],
        [1,0,1,1,1,1,0,1,1,0,0,0,0,2,2,2,2,0,0,0,0,1,0,1,1,1,1,0,1,1],
        [1,1,1,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1],
        [1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1],
        [1,0,1,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,0,1,1,1,0,1],
        [1,0,1,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,0,1,1,1,0,1],
        [1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1],
        [1,1,1,1,1,1,0,1,1,0,1,1,1,1,1,1,1,1,0,1,1,0,1,1,1,1,1,1,0,0],
        [1,1,1,1,1,1,0,1,1,0,1,1,1,1,1,1,1,1,0,1,1,0,1,1,1,1,1,1,0,0],
        [1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1],
        [1,0,1,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,0,1,1,1,0,1],
        [1,0,1,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,0,1,1,1,0,1],
        [1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1],
        [1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1]
    ];

    // Ghost den coordinates and entrance. Path `2` is only for ghost den drawing.
    const GHOST_DEN_SPAWN = { x: 15, y: 15 }; // Inside the den, for initial placement
    const GHOST_DEN_EXIT_PATH = { x: 14, y: 14 }; // Path ghosts take to exit
    const SNAKE_START_POS = { x: 1, y: 1 };

    // --- Helper Functions for Drawing ---
    function drawRect(x, y, width, height, color, borderColor, borderWidth = 2, shadow = true) {
        ctx.fillStyle = color;
        ctx.fillRect(x, y, width, height);
        ctx.strokeStyle = borderColor;
        ctx.lineWidth = borderWidth;
        ctx.strokeRect(x, y, width, height);
        if (shadow) {
            ctx.fillStyle = COLOR_BORDER;
            ctx.fillRect(x + borderWidth, y + borderWidth, width, height);
            ctx.fillStyle = color;
            ctx.fillRect(x, y, width - borderWidth, height - borderWidth);
            ctx.strokeStyle = borderColor;
            ctx.lineWidth = borderWidth;
            ctx.strokeRect(x, y, width - borderWidth, height - borderWidth);
        }
    }

    function drawCircle(x, y, radius, color, borderColor, borderWidth = 1, shadow = true) {
        ctx.beginPath();
        ctx.arc(x, y, radius, 0, Math.PI * 2);
        ctx.fillStyle = color;
        ctx.fill();
        ctx.strokeStyle = borderColor;
        ctx.lineWidth = borderWidth;
        ctx.stroke();
        if (shadow) {
            // For circles, a simple offset fill could simulate shadow
            ctx.fillStyle = COLOR_BORDER;
            ctx.beginPath();
            ctx.arc(x + borderWidth, y + borderWidth, radius, 0, Math.PI * 2);
            ctx.fill();
            ctx.beginPath();
            ctx.arc(x, y, radius - borderWidth, 0, Math.PI * 2);
            ctx.fillStyle = color;
            ctx.fill();
            ctx.strokeStyle = borderColor;
            ctx.lineWidth = borderWidth;
            ctx.stroke();
        }
    }

    // --- Game Logic Functions ---

    function initGame() {
        score = 0;
        lives = LIVES_START;
        loadHighScore();
        gameState = 'START';
        resetGameEntities();
        setupEventListeners();
        draw(); // Draw initial start screen

        // Autostart the game immediately upon loading
        if (gameState === 'START') {
            startGame();
        }
    }

    function resetGameEntities() {
        // Reset Snake
        snake = [];
        for (let i = 0; i < INITIAL_SNAKE_LENGTH; i++) {
            snake.push({ x: SNAKE_START_POS.x - i, y: SNAKE_START_POS.y });
        }
        snakeDirection = { x: 1, y: 0 };
        nextDirection = { x: 1, y: 0 };

        // Reset Ghosts
        ghosts = [
            { id: 'blinky', x: GHOST_DEN_SPAWN.x, y: GHOST_DEN_SPAWN.y, color: GHOST_BLINKY_COLOR, state: GHOST_STATE.NORMAL, target: null, speed: GHOST_SPEED_NORMAL, respawnTimer: 0, path: [], lastMoveTime: 0, scatterTarget: {x: GRID_WIDTH - 2, y: 1}, originalTarget: null },
            { id: 'pinky', x: GHOST_DEN_SPAWN.x + 1, y: GHOST_DEN_SPAWN.y, color: GHOST_PINKY_COLOR, state: GHOST_STATE.NORMAL, target: null, speed: GHOST_SPEED_NORMAL, respawnTimer: 0, path: [], lastMoveTime: 0, scatterTarget: {x: 1, y: 1}, originalTarget: null },
            { id: 'inky', x: GHOST_DEN_SPAWN.x, y: GHOST_DEN_SPAWN.y + 1, color: GHOST_INKY_COLOR, state: GHOST_STATE.NORMAL, target: null, speed: GHOST_SPEED_NORMAL, respawnTimer: 0, path: [], lastMoveTime: 0, scatterTarget: {x: GRID_WIDTH - 2, y: GRID_HEIGHT - 2}, originalTarget: null },
            { id: 'clyde', x: GHOST_DEN_SPAWN.x + 1, y: GHOST_DEN_SPAWN.y + 1, color: GHOST_CLYDE_COLOR, state: GHOST_STATE.NORMAL, target: null, speed: GHOST_SPEED_NORMAL, respawnTimer: 0, path: [], lastMoveTime: 0, scatterTarget: {x: 1, y: GRID_HEIGHT - 2}, originalTarget: null }
        ];

        // Generate Food
        generatePellets();

        // Reset Power-up state
        powerUpActive = false;
        powerUpTimer = 0;
        frightenedGhostFlashTimer = 0;
        frightenedGhostsEatenThisPowerUp = 0;

        clearInterval(gameInterval);
        Object.values(ghostIntervals).forEach(clearInterval);
        ghostIntervals = {};
    }

    function generatePellets() {
        foodPellets = [];
        powerPellets = [];
        const powerPelletPositions = [
            { x: 1, y: 3 }, { x: GRID_WIDTH - 2, y: 3 },
            { x: 1, y: GRID_HEIGHT - 4 }, { x: GRID_WIDTH - 2, y: GRID_HEIGHT - 4 }
        ];

        for (let y = 0; y < GRID_HEIGHT; y++) {
            for (let x = 0; x < GRID_WIDTH; x++) {
                // Only place pellets on path cells (0) and not in the ghost den (2)
                if (MAZE_GRID[y][x] === 0) {
                    let isPowerPelletSpot = false;
                    for (const pp of powerPelletPositions) {
                        if (pp.x === x && pp.y === y) {
                            powerPellets.push({ x, y });
                            isPowerPelletSpot = true;
                            break;
                        }
                    }
                    if (!isPowerPelletSpot) {
                        foodPellets.push({ x, y });
                    }
                }
            }
        }
    }

    function startGame() {
        gameState = 'PLAYING';
        startScreen.classList.add('hidden');
        pausedScreen.classList.add('hidden');
        gameOverScreen.classList.add('hidden');

        // Start game loop
        lastUpdateTime = performance.now();
        gameInterval = setInterval(gameTick, GAME_SPEED);
        ghosts.forEach(ghost => {
            ghostIntervals[ghost.id] = setInterval(() => moveGhost(ghost), ghost.speed);
        });
    }

    function pauseGame() {
        if (gameState === 'PLAYING') {
            gameState = 'PAUSED';
            pausedScreen.classList.remove('hidden');
            clearInterval(gameInterval);
            Object.values(ghostIntervals).forEach(clearInterval);
        }
    }

    function resumeGame() {
        if (gameState === 'PAUSED') {
            gameState = 'PLAYING';
            pausedScreen.classList.add('hidden');
            lastUpdateTime = performance.now();
            gameInterval = setInterval(gameTick, GAME_SPEED);
            ghosts.forEach(ghost => {
                if (ghost.respawnTimer === 0) {
                    ghostIntervals[ghost.id] = setInterval(() => moveGhost(ghost), ghost.speed);
                }
            });
        }
    }

    function gameOver() {
        gameState = 'GAME_OVER';
        gameOverScreen.classList.remove('hidden');
        finalScoreDisplay.textContent = score;
        clearInterval(gameInterval);
        Object.values(ghostIntervals).forEach(clearInterval);
        if (score > highScore) {
            highScore = score;
            saveHighScore();
        }
        updateUI();
    }

    function gameTick() {
        if (gameState !== 'PLAYING') return;

        updateSnake();
        updatePowerUpState();
        checkCollisions();
        draw();
    }

    function updateSnake() {
        // Apply next direction if valid (not 180 turn)
        // Only update snakeDirection if nextDirection is valid and not directly opposite
        if ((nextDirection.x !== -snakeDirection.x || nextDirection.y !== -snakeDirection.y) || snake.length === 1) {
            snakeDirection = nextDirection;
        }

        const currentHead = snake[0];
        let potentialHeadX = currentHead.x + snakeDirection.x;
        let potentialHeadY = currentHead.y + snakeDirection.y;

        // Toroidal wrapping for outer boundaries (apply to potential position)
        potentialHeadX = (potentialHeadX + GRID_WIDTH) % GRID_WIDTH;
        potentialHeadY = (potentialHeadY + GRID_HEIGHT) % GRID_HEIGHT;

        // Check for collision with internal walls at the potential new position
        if (MAZE_GRID[potentialHeadY][potentialHeadX] === 1) {
            // Snake hits a wall, it stops at its current position.
            // The snakeDirection and nextDirection are preserved for future turns.
            // No movement, no life lost.
            return;
        }

        // If no wall collision, proceed to move the snake
        const newHead = { x: potentialHeadX, y: potentialHeadY };
        snake.unshift(newHead); // Add new head

        let eatenFood = false;
        let eatenPowerPellet = false;

        // Check for food collision (only with the new head)
        for (let i = 0; i < foodPellets.length; i++) {
            if (foodPellets[i].x === newHead.x && foodPellets[i].y === newHead.y) {
                foodPellets.splice(i, 1);
                score += 10;
                eatenFood = true;
                break;
            }
        }

        // Check for power pellet collision (only with the new head)
        for (let i = 0; i < powerPellets.length; i++) {
            if (powerPellets[i].x === newHead.x && powerPellets[i].y === newHead.y) {
                powerPellets.splice(i, 1);
                score += 50;
                activatePowerUp();
                eatenPowerPellet = true;
                break;
            }
        }

        // Snake only grows if a power pellet (red ball) was eaten.
        // If only a regular food pellet was eaten, or nothing, the tail still pops.
        if (!eatenPowerPellet) {
            snake.pop(); // Remove tail
        }

        // If all food is eaten, regenerate for a new 'level' or just keep playing
        if (foodPellets.length === 0 && powerPellets.length === 0) {
            generatePellets();
        }
    }

    function updatePowerUpState() {
        if (powerUpActive) {
            powerUpTimer -= GAME_SPEED;
            if (powerUpTimer <= 0) {
                powerUpActive = false;
                frightenedGhostFlashTimer = 0;
                frightenedGhostsEatenThisPowerUp = 0;
                ghosts.forEach(ghost => {
                    if (ghost.state === GHOST_STATE.FRIGHTENED) {
                        ghost.state = GHOST_STATE.NORMAL;
                        ghost.speed = GHOST_SPEED_NORMAL;
                        clearInterval(ghostIntervals[ghost.id]);
                        ghostIntervals[ghost.id] = setInterval(() => moveGhost(ghost), ghost.speed);
                    }
                });
            } else if (powerUpTimer <= POWER_UP_FLASH_THRESHOLD) {
                frightenedGhostFlashTimer += GAME_SPEED;
            }
        }
    }

    function activatePowerUp() {
        powerUpActive = true;
        powerUpTimer = POWER_UP_DURATION;
        frightenedGhostsEatenThisPowerUp = 0;
        ghosts.forEach(ghost => {
            if (ghost.state === GHOST_STATE.NORMAL) {
                ghost.state = GHOST_STATE.FRIGHTENED;
                ghost.speed = GHOST_SPEED_FRIGHTENED;
                // Ghosts reverse direction when frightened
                // For simplicity, we just clear path for pathfinding to re-calculate, or set a direct opposite target
                ghost.path = []; // Clear path so new path to flee can be calculated
                clearInterval(ghostIntervals[ghost.id]);
                ghostIntervals[ghost.id] = setInterval(() => moveGhost(ghost), ghost.speed);
            }
        });
    }

    function checkCollisions() {
        const head = snake[0];

        // Self-collision
        for (let i = 1; i < snake.length; i++) {
            if (head.x === snake[i].x && head.y === snake[i].y) {
                loseLife();
                return;
            }
        }

        // Ghost collision
        for (const ghost of ghosts) {
            if (ghost.x === head.x && ghost.y === head.y) {
                if (ghost.state === GHOST_STATE.FRIGHTENED && powerUpActive) {
                    eatGhost(ghost);
                } else if (ghost.state === GHOST_STATE.NORMAL) {
                    loseLife();
                    return;
                }
            }
        }
    }

    function loseLife() {
        lives--;
        if (lives <= 0) {
            gameOver();
        } else {
            resetPlayerPosition();
        }
    }

    function resetPlayerPosition() {
        // Reset snake and ghosts to initial positions
        snake = [];
        for (let i = 0; i < INITIAL_SNAKE_LENGTH; i++) {
            snake.push({ x: SNAKE_START_POS.x - i, y: SNAKE_START_POS.y });
        }
        snakeDirection = { x: 1, y: 0 };
        nextDirection = { x: 1, y: 0 };

        ghosts.forEach(ghost => {
            ghost.x = GHOST_DEN_SPAWN.x;
            ghost.y = GHOST_DEN_SPAWN.y;
            ghost.state = GHOST_STATE.NORMAL;
            ghost.speed = GHOST_SPEED_NORMAL;
            ghost.respawnTimer = 0;
            ghost.path = [];
            clearInterval(ghostIntervals[ghost.id]);
            ghostIntervals[ghost.id] = setInterval(() => moveGhost(ghost), ghost.speed);
        });
        powerUpActive = false;
        powerUpTimer = 0;
        frightenedGhostFlashTimer = 0;
        frightenedGhostsEatenThisPowerUp = 0;

        // Restart game loop if currently playing, otherwise it's game over and loop stopped.
        if (gameState === 'PLAYING') {
            clearInterval(gameInterval);
            gameInterval = setInterval(gameTick, GAME_SPEED);
        }
        draw(); // Redraw immediately after reset to show new positions
    }

    function eatGhost(ghost) {
        score += 200 * Math.pow(2, frightenedGhostsEatenThisPowerUp); // Bonus for consecutive eats
        frightenedGhostsEatenThisPowerUp++;
        ghost.state = GHOST_STATE.EYES_ONLY;
        ghost.speed = GHOST_SPEED_EATEN;
        ghost.respawnTimer = GHOST_RESPAWN_DELAY;
        clearInterval(ghostIntervals[ghost.id]);
        ghostIntervals[ghost.id] = setInterval(() => moveGhost(ghost), ghost.speed);
    }

    // --- Ghost AI and Movement ---

    function isValidMove(x, y) {
        // Check if the coordinate is within bounds and not a wall (1)
        // Ghosts can move through ghost den paths (2)
        return MAZE_GRID[y][x] !== 1; 
    }

    function getNeighbors(x, y) {
        const neighbors = [];
        const directions = [
            { dx: 0, dy: -1 }, // Up
            { dx: 0, dy: 1 },  // Down
            { dx: -1, dy: 0 }, // Left
            { dx: 1, dy: 0 }   // Right
        ];

        for (const dir of directions) {
            let nx = x + dir.dx;
            let ny = y + dir.dy;

            // Toroidal wrapping for neighbors
            nx = (nx + GRID_WIDTH) % GRID_WIDTH;
            ny = (ny + GRID_HEIGHT) % GRID_HEIGHT;

            if (isValidMove(nx, ny)) {
                neighbors.push({ x: nx, y: ny, dx: dir.dx, dy: dir.dy });
            }
        }
        return neighbors;
    }

    function getPathToTarget(startX, startY, targetX, targetY, ghostId) {
        const queue = [{ x: startX, y: startY, path: [] }];
        const visited = new Set();
        visited.add(`${startX},${startY}`);

        while (queue.length > 0) {
            const { x, y, path } = queue.shift();

            if (x === targetX && y === targetY) {
                return path;
            }

            for (const neighbor of getNeighbors(x, y)) {
                const neighborKey = `${neighbor.x},${neighbor.y}`;
                // Prevent ghosts from immediately reversing, unless specifically requested for frightened mode
                const lastMove = path[path.length - 1];
                if (lastMove && neighbor.dx === -lastMove.dx && neighbor.dy === -lastMove.dy) {
                    continue;
                }

                if (!visited.has(neighborKey)) {
                    visited.add(neighborKey);
                    queue.push({ x: neighbor.x, y: neighbor.y, path: [...path, { dx: neighbor.dx, dy: neighbor.dy }] });
                }
            }
        }
        return []; // No path found
    }

    function getTargetForGhost(ghost) {
        const head = snake[0];
        let target = { ...head }; // Default target is snake's head

        switch (ghost.id) {
            case 'blinky': // Blinky: Always chases Pac-Snake's current position
                target = { ...head };
                break;
            case 'pinky': // Pinky: Tries to ambush, targets 4 cells ahead of Pac-Snake
                target.x = head.x + snakeDirection.x * 4;
                target.y = head.y + snakeDirection.y * 4;
                break;
            case 'inky': // Inky: Targets a point based on player and Blinky
                const blinky = ghosts.find(g => g.id === 'blinky');
                if (blinky) {
                    let blx = blinky.x;
                    let bly = blinky.y;
                    let px = head.x + snakeDirection.x * 2; // 2 cells ahead of snake
                    let py = head.y + snakeDirection.y * 2;

                    // Vector from blinky to 2-tiles-ahead-of-snake, then double it
                    target.x = blx + 2 * (px - blx);
                    target.y = bly + 2 * (py - bly);
                }
                break;
            case 'clyde': // Clyde: Scatter behavior unless snake is too close, then flees
                const distanceToSnake = Math.abs(head.x - ghost.x) + Math.abs(head.y - ghost.y);
                if (distanceToSnake < 8) { // If snake is within 8 cells, flee to scatter corner
                    target = ghost.scatterTarget;
                } else { // Otherwise, target snake's head (default behavior here, could be more random)
                    target = { ...head };
                }
                break;
        }
        // Ensure targets are within grid bounds (toroidal handled by wrap function in pathfinding)
        target.x = (target.x + GRID_WIDTH) % GRID_WIDTH;
        target.y = (target.y + GRID_HEIGHT) % GRID_HEIGHT;
        return target;
    }

    function moveGhost(ghost) {
        if (gameState !== 'PLAYING') return;

        // Respawn logic
        if (ghost.respawnTimer > 0) {
            ghost.respawnTimer -= ghost.speed;
            if (ghost.respawnTimer <= 0) {
                // Reset ghost to den
                ghost.x = GHOST_DEN_SPAWN.x;
                ghost.y = GHOST_DEN_SPAWN.y;
                ghost.state = GHOST_STATE.NORMAL;
                ghost.speed = GHOST_SPEED_NORMAL;
                clearInterval(ghostIntervals[ghost.id]);
                ghostIntervals[ghost.id] = setInterval(() => moveGhost(ghost), ghost.speed);
            }
            // Even if respawning, if it's eyes only, it still needs to move back to den
            if (ghost.state === GHOST_STATE.EYES_ONLY) {
                // Target the den entrance, not just spawn point for return pathing
                ghost.target = GHOST_DEN_EXIT_PATH; 
            } else {
                return; // Don't move if not eyes only and still respawning
            }
        }

        let targetPosition;
        if (ghost.state === GHOST_STATE.FRIGHTENED) {
            // Flee: target a cell far away from snake's current position
            const head = snake[0];
            // Calculate a target that is generally away from the snake
            targetPosition = { x: ghost.x + (ghost.x - head.x), y: ghost.y + (ghost.y - head.y) };
            targetPosition.x = (targetPosition.x + GRID_WIDTH) % GRID_WIDTH;
            targetPosition.y = (targetPosition.y + GRID_HEIGHT) % GRID_HEIGHT;
            // Clamp target to valid maze paths, if it lands on a wall, re-adjust to a random valid path
            if (MAZE_GRID[targetPosition.y][targetPosition.x] === 1) {
                const validRandomMoves = getNeighbors(ghost.x, ghost.y);
                if (validRandomMoves.length > 0) {
                    const randomMove = validRandomMoves[Math.floor(Math.random() * validRandomMoves.length)];
                    targetPosition = {x: randomMove.x, y: randomMove.y};
                } else {
                    targetPosition = ghost.scatterTarget; // Fallback to scatter corner
                }
            }
        } else if (ghost.state === GHOST_STATE.EYES_ONLY) {
            targetPosition = GHOST_DEN_SPAWN; // Return to den
        } else { // NORMAL state
            targetPosition = getTargetForGhost(ghost);
        }

        // Get possible moves from current ghost position
        const possibleMoves = getNeighbors(ghost.x, ghost.y);
        let bestMove = null;
        let minOrMaxDistance = (ghost.state === GHOST_STATE.FRIGHTENED) ? -Infinity : Infinity;

        // Calculate Euclidean distance (squared for performance, doesn't change order)
        function getDistance(p1, p2) {
            let dx = p1.x - p2.x;
            let dy = p1.y - p2.y;
            return dx * dx + dy * dy;
        }

        // Determine the best move based on ghost state
        for (const move of possibleMoves) {
            const newX = move.x;
            const newY = move.y;

            // Prevent immediate 180-degree turns unless frightened and this is the only option
            // or if it's pathing to the den (eyes_only)
            const lastMoveDir = ghost.path.length > 0 ? ghost.path[ghost.path.length - 1] : {dx:0, dy:0};
            const isReverseMove = (move.dx === -lastMoveDir.dx && move.dy === -lastMoveDir.dy);

            if (isReverseMove && ghost.state !== GHOST_STATE.FRIGHTENED && possibleMoves.length > 1 && ghost.state !== GHOST_STATE.EYES_ONLY) {
                continue; // Do not reverse direction unless frightened or no other choice, or eyes only returning to den
            }

            let currentDistance;
            if (ghost.state === GHOST_STATE.FRIGHTENED) {
                // Fleeing: choose the move that MAXIMIZES distance to snake's head
                currentDistance = getDistance({ x: newX, y: newY }, snake[0]);
                if (currentDistance > minOrMaxDistance) {
                    minOrMaxDistance = currentDistance;
                    bestMove = move;
                }
            } else { 
                // Normal or Eyes_Only: choose the move that MINIMIZES distance to target
                currentDistance = getDistance({ x: newX, y: newY }, targetPosition);
                if (currentDistance < minOrMaxDistance) {
                    minOrMaxDistance = currentDistance;
                    bestMove = move;
                }
            }
        }

        if (bestMove) {
            ghost.x = bestMove.x;
            ghost.y = bestMove.y;
            ghost.path.push({dx: bestMove.dx, dy: bestMove.dy});
            // Keep only the last two moves to accurately prevent immediate reversal
            if (ghost.path.length > 2) ghost.path.shift(); 
        }
    }

    // --- UI Update and Drawing ---

    function updateUI() {
        scoreDisplay.textContent = score; // Display current score
        highScoreDisplay.textContent = highScore; // High score is always just the number

        livesContainer.innerHTML = '';
        for (let i = 0; i < lives; i++) {
            const lifeIcon = document.createElement('div');
            lifeIcon.className = 'life-icon';
            livesContainer.appendChild(lifeIcon);
        }

        if (powerUpActive) {
            const secondsLeft = Math.ceil(powerUpTimer / 1000);
            powerUpTimerDisplay.textContent = secondsLeft;
            // Flash primary color when power-up is about to end
            if (powerUpTimer <= POWER_UP_FLASH_THRESHOLD && Math.floor(frightenedGhostFlashTimer / 250) % 2 === 0) {
                powerUpTimerDisplay.style.color = COLOR_PRIMARY;
            } else {
                powerUpTimerDisplay.style.color = COLOR_MUTED_TEXT;
            }
        } else {
            powerUpTimerDisplay.textContent = '--';
            powerUpTimerDisplay.style.color = COLOR_MUTED_TEXT;
        }
    }

    function draw() {
        ctx.clearRect(0, 0, canvas.width, canvas.height);

        // Draw maze paths (background)
        for (let y = 0; y < GRID_HEIGHT; y++) {
            for (let x = 0; x < GRID_WIDTH; x++) {
                if (MAZE_GRID[y][x] === 0 || MAZE_GRID[y][x] === 2) { // Draw path or den floor
                    ctx.fillStyle = COLOR_SURFACE;
                    ctx.fillRect(x * GRID_SIZE, y * GRID_SIZE, GRID_SIZE, GRID_SIZE);
                }
            }
        }

        // Draw maze walls
        for (let y = 0; y < GRID_HEIGHT; y++) {
            for (let x = 0; x < GRID_WIDTH; x++) {
                if (MAZE_GRID[y][x] === 1) {
                    drawRect(x * GRID_SIZE, y * GRID_SIZE, GRID_SIZE, GRID_SIZE, WALL_COLOR, WALL_BORDER_COLOR, 2);
                }
            }
        }

        // Draw food pellets
        for (const food of foodPellets) {
            drawCircle(food.x * GRID_SIZE + GRID_SIZE / 2, food.y * GRID_SIZE + GRID_SIZE / 2, GRID_SIZE / 8, FOOD_COLOR, FOOD_BORDER_COLOR, 1, false);
        }

        // Draw power pellets (pulsing)
        const pulseScale = powerUpActive && powerUpTimer <= POWER_UP_FLASH_THRESHOLD && Math.floor(frightenedGhostFlashTimer / 250) % 2 === 0 ? 0.8 : 1;
        const radius = (GRID_SIZE / 3) * pulseScale;
        for (const pp of powerPellets) {
            drawCircle(pp.x * GRID_SIZE + GRID_SIZE / 2, pp.y * GRID_SIZE + GRID_SIZE / 2, radius, POWER_PELLET_COLOR, POWER_PELLET_BORDER_COLOR, 2, true);
        }

        // Draw snake
        for (let i = 0; i < snake.length; i++) {
            const segment = snake[i];
            drawRect(segment.x * GRID_SIZE, segment.y * GRID_SIZE, GRID_SIZE, GRID_SIZE, SNAKE_COLOR, SNAKE_BORDER_COLOR, 2);

            // Draw eyes for snake head
            if (i === 0) {
                const eyeSize = GRID_SIZE / 6;
                const eyeOffset = GRID_SIZE / 4;
                const pupilOffset = GRID_SIZE / 16;

                let eye1X = segment.x * GRID_SIZE + eyeOffset;
                let eye1Y = segment.y * GRID_SIZE + eyeOffset;
                let eye2X = segment.x * GRID_SIZE + GRID_SIZE - eyeOffset;
                let eye2Y = segment.y * GRID_SIZE + eyeOffset;

                let pupil1X = eye1X;
                let pupil1Y = eye1Y;
                let pupil2X = eye2X;
                let pupil2Y = eye2Y;

                if (snakeDirection.x === 1) { // Right
                    pupil1X += pupilOffset;
                    pupil2X += pupilOffset;
                } else if (snakeDirection.x === -1) { // Left
                    pupil1X -= pupilOffset;
                    pupil2X -= pupilOffset;
                } else if (snakeDirection.y === -1) { // Up
                    pupil1Y -= pupilOffset;
                    pupil2Y -= pupilOffset;
                } else if (snakeDirection.y === 1) { // Down
                    pupil1Y += pupilOffset;
                    pupil2Y += pupilOffset;
                }

                drawCircle(eye1X, eye1Y, eyeSize, COLOR_TEXT, COLOR_BORDER, 1, false);
                drawCircle(pupil1X, pupil1Y, eyeSize / 2, COLOR_MUTED_TEXT, COLOR_BORDER, 1, false);

                drawCircle(eye2X, eye2Y, eyeSize, COLOR_TEXT, COLOR_BORDER, 1, false);
                drawCircle(pupil2X, pupil2Y, eyeSize / 2, COLOR_MUTED_TEXT, COLOR_BORDER, 1, false);
            }
        }

        // Draw ghosts
        for (const ghost of ghosts) {
            let ghostColor = ghost.color;
            if (ghost.state === GHOST_STATE.FRIGHTENED) {
                // Flashing frightened state
                if (powerUpTimer <= POWER_UP_FLASH_THRESHOLD && Math.floor(frightenedGhostFlashTimer / 250) % 2 === 0) {
                    ghostColor = COLOR_MUTED_TEXT; // Flash white
                } else {
                    ghostColor = GHOST_FRIGHTENED_COLOR;
                }
            }

            const ghostX = ghost.x * GRID_SIZE;
            const ghostY = ghost.y * GRID_SIZE;

            if (ghost.state === GHOST_STATE.EYES_ONLY) {
                // Draw only eyes
                // Simplified eye drawing for eaten state
                const eyeWhiteSize = GRID_SIZE / 6;
                const pupilSize = GRID_SIZE / 12;

                // Left eye
                drawCircle(ghostX + GRID_SIZE / 2 - GRID_SIZE / 8, ghostY + GRID_SIZE / 2, eyeWhiteSize, GHOST_EATEN_EYE_COLOR, COLOR_BORDER, 1, false);
                drawCircle(ghostX + GRID_SIZE / 2 - GRID_SIZE / 8, ghostY + GRID_SIZE / 2, pupilSize, COLOR_BORDER, COLOR_BORDER, 1, false);
                // Right eye
                drawCircle(ghostX + GRID_SIZE / 2 + GRID_SIZE / 8, ghostY + GRID_SIZE / 2, eyeWhiteSize, GHOST_EATEN_EYE_COLOR, COLOR_BORDER, 1, false);
                drawCircle(ghostX + GRID_SIZE / 2 + GRID_SIZE / 8, ghostY + GRID_SIZE / 2, pupilSize, COLOR_BORDER, COLOR_BORDER, 1, false);

            } else {
                // Draw ghost body
                drawRect(ghostX, ghostY, GRID_SIZE, GRID_SIZE, ghostColor, COLOR_BORDER, 2);
                // Draw ghost eyes
                const eyeWhiteSize = GRID_SIZE / 8;
                const pupilSize = GRID_SIZE / 12;
                const eyeOffset = GRID_SIZE / 4; // Horizontal offset from center
                const eyeYOffset = GRID_SIZE / 8; // Vertical offset from top

                // Left eye
                drawCircle(ghostX + eyeOffset, ghostY + eyeYOffset + eyeWhiteSize, eyeWhiteSize, COLOR_MUTED_TEXT, COLOR_BORDER, 1, false);
                drawCircle(ghostX + eyeOffset, ghostY + eyeYOffset + eyeWhiteSize, pupilSize, COLOR_BORDER, COLOR_BORDER, 1, false);
                // Right eye
                drawCircle(ghostX + GRID_SIZE - eyeOffset, ghostY + eyeYOffset + eyeWhiteSize, eyeWhiteSize, COLOR_MUTED_TEXT, COLOR_BORDER, 1, false);
                drawCircle(ghostX + GRID_SIZE - eyeOffset, ghostY + eyeYOffset + eyeWhiteSize, pupilSize, COLOR_BORDER, COLOR_BORDER, 1, false);
            }
        }

        updateUI();
    }

    // --- Event Listeners ---
    function setupEventListeners() {
        document.addEventListener('keydown', handleKeyPress);
        startButton.addEventListener('click', startGame);
        resumeButton.addEventListener('click', resumeGame);
        restartButton.addEventListener('click', () => {
            resetGameEntities();
            score = 0; // Ensure score is reset on full restart
            lives = LIVES_START;
            startGame();
        });
    }

    function handleKeyPress(e) {
        // Autostart already handles starting the game, these conditions might be redundant
        // but kept for explicit key presses for START/RESTART screens if ever they appear manually.
        if (gameState === 'START' && e.key === 'Enter') {
            startGame();
            return;
        }
        if (gameState === 'GAME_OVER' && e.key === 'Enter') {
            resetGameEntities();
            score = 0;
            lives = LIVES_START;
            startGame();
            return;
        }

        switch (e.key) {
            case 'ArrowUp':
            case 'w':
                // Only allow changing direction if not immediately reversing
                if (snakeDirection.y !== 1) nextDirection = { x: 0, y: -1 };
                break;
            case 'ArrowDown':
            case 's':
                if (snakeDirection.y !== -1) nextDirection = { x: 0, y: 1 };
                break;
            case 'ArrowLeft':
            case 'a':
                if (snakeDirection.x !== 1) nextDirection = { x: -1, y: 0 };
                break;
            case 'ArrowRight':
            case 'd':
                if (snakeDirection.x !== -1) nextDirection = { x: 1, y: 0 };
                break;
            case 'p':
            case 'Escape':
                if (gameState === 'PLAYING') {
                    pauseGame();
                } else if (gameState === 'PAUSED') {
                    resumeGame();
                }
                break;
        }
        e.preventDefault(); // Prevent default browser actions for arrow keys/space
    }

    function loadHighScore() {
        highScore = parseInt(localStorage.getItem('pacSnakeHighScore') || '0', 10);
    }

    function saveHighScore() {
        localStorage.setItem('pacSnakeHighScore', highScore.toString());
    }

    // Initialize the game when the script loads
    initGame();
});
