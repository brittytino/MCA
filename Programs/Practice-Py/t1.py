class Node:
    def __init__(self, data):
        self.data = data
        self.children = []

    def add_child(self, child_node):
        self.children.append(child_node)

    def display(self, level=0):
        print("  " * level + f"- {self.data}")
        for child in self.children:
            child.display(level + 1)


def build_tree():
    root_data = int(input("Enter root node (number): "))
    root = Node(root_data)

    num_children = int(input(f"How many children does '{root_data}' have? "))

    for _ in range(num_children):
        child_data = int(input("Enter child node (number): "))
        child_node = Node(child_data)
        root.add_child(child_node)

        add_more = input(f"Do you want to add children to '{child_data}'? (y/n): ").lower()
        if add_more == 'y':
            add_subtree(child_node)

    return root


def add_subtree(parent_node):
    num_children = int(input(f"How many children does '{parent_node.data}' have? "))
    for _ in range(num_children):
        child_data = int(input("Enter child node (number): "))
        child_node = Node(child_data)
        parent_node.add_child(child_node)

        add_more = input(f"Do you want to add children to '{child_data}'? (y/n): ").lower()
        if add_more == 'y':
            add_subtree(child_node)


# --- Run the program ---
if __name__ == "__main__":
    tree = build_tree()
    print("\nTree structure:")
    tree.display()
